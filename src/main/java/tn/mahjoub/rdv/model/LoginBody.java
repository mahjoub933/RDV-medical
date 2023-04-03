package tn.mahjoub.rdv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {

    @NotNull(message = "Username not null.")
    private String username;

    @NotNull(message = "Password not null.")
    private String password;
}
