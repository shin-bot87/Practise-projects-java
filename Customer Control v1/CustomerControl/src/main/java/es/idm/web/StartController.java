package es.idm.web;

import es.idm.domain.Person;
import es.idm.service.PersonService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class StartController {
   
    @Autowired
    private PersonService personService;
    
    @GetMapping("/")
    public String start(Model model, @AuthenticationPrincipal User user){
        var people = personService.listPerson();
        log.info("Running Spring MVC controller");
        log.info("User avoid loggin attempt" + user);
        model.addAttribute("people", people);
        var totalBalance = 0D;
        for (var p: people) {
            totalBalance += p.getBalance();
        }
        model.addAttribute("totalBalance", totalBalance);
        model.addAttribute("totalCustomers", people.size());
        return "index";
    }
    
    @GetMapping("/add")
    public String add(Person person){
        return "alter";
    }
    
    @PostMapping("/save")
    public String save(@Valid Person person, Errors wrong){
        if(wrong.hasErrors()){
            return "alter";
        }
        personService.save(person);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{idPerson}")
    public String edit(Person person, Model model){
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "alter";
    }
    
    @GetMapping("/delete")
    public String delete(Person person){
        personService.delete(person);
        return "redirect:/";
    }
}
