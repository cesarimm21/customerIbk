package interbank.com.pe.model;

import interbank.com.pe.model.passwords.ContrasenaBuilder;

public class Contrasena {

    private final String newPassword;
    private final String repeatPassword;

    public Contrasena(ContrasenaBuilder builder) {
        this.newPassword = builder.getNewPassword();
        this.repeatPassword = builder.getRepeatPassword();
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
