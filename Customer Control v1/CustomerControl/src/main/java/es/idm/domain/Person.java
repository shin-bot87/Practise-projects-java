package es.idm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "person")
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String surname;
    
    @NotEmpty
    @Email
    private String email;
    
    private String phone;
    
    @NotNull
    private Double balance;
}
