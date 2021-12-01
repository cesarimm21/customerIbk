package interbank.com.pe.model;

import interbank.com.pe.model.passwords.ContrasenaLoginBuilder;

public class ContrasenaLogin {

    private final String password;

    public ContrasenaLogin(ContrasenaLoginBuilder builder) {
        this.password = builder.getPassword();
    }

    public String getPassword() {
        return password;
    }

}
