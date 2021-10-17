package com.example.final_project.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import com.example.final_project.dto.UserDTO;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name="user",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;

   public User(String firstName, String lastName, String email, String password, RoleType role) {
       this.firstName=firstName;
       this.lastName=lastName;
       this.email=email;
       this.password=password;
       this.role=role;
   }

   public User(UserDTO userDTO){
       this.email=userDTO.getEmail();
       this.password=userDTO.getPassword();
       this.firstName=userDTO.getFirstname();
       this.lastName=userDTO.getLastname();
   }
}
