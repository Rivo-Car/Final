package com.example.final_project.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class UserDTO {
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(?=.{5,20}$)(?![_.])(?!.*[_.]{2})[а-щА-ЩЬьЮюЯяЇїІіЄєҐґa-zA-Z0-9._]+(?<![_.])$",
            message = "{valid.user.firstname}")
    private String Firstname;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(?=.{5,20}$)(?![_.])(?!.*[_.]{2})[а-щА-ЩЬьЮюЯяЇїІіЄєҐґa-zA-Z0-9._]+(?<![_.])$",
            message = "{valid.user.firstname}")
    private String Lastname;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message = "{valid.user.email}")
    private String email;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^.{6,100}$", message = "{valid.user.password}")
    private String password;
}
