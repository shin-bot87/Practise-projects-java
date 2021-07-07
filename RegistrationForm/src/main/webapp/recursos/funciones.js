function formSuccess(form){
    var user = form.user;
    if(user.value === "" || user.value === "Type your username"){
        alert("A user is required");
        user.focus();
        user.select();
        return false;
    }
    
    var password = form.password;
    if(password.value === "" || password.value.length < 3){
        alert("The password must have at least 3 characters");
        password.focus();
        password.select();
        return false;
    }
    
    var technologies = form.technology;
    var selectedCheck = false;
    
    for( var i = 0; i < technologies.length; i++ ){
        if(technologies[i].checked){
            selectedCheck = true;
        }
    }
    
    if(!selectedCheck){
        alert("You must choose at least 1 technology");
        return false;
    }
    
    var genders = form.gender;
    var selectedRadio = false;
    
    for( var i = 0; i < genders.length; i++ ){
        if(genders[i].checked){
            selectedRadio = true;
        }
    }
    
    if(!selectedRadio){
        alert("You must choose your gender");
        return false;
    }
    
    var occupation = form.occupation;
    if(occupation.value === ""){
        alert("You must choose your occupation");
        return false;
    }
    
    alert("Valid form, sending to the server");
    return true;
}