package interbank.com.pe.model.passwords;

import interbank.com.pe.exceptions.ContrasenaException;
import interbank.com.pe.model.Contrasena;
import interbank.com.pe.utils.builders.Builder;

public class ContrasenaBuilder implements Builder<Contrasena> {

    private final String newPassword;
    private final String repeatPassword;

    public ContrasenaBuilder(String newPassword, String repeatPassword) {
        this.newPassword = newPassword;
        this.repeatPassword = repeatPassword;
    }

    public static ContrasenaBuilder password(String newPassword, String repeatPassword) {
        return new ContrasenaBuilder(newPassword, repeatPassword);
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    @Override
    public Contrasena build() throws ContrasenaException {
        return new Contrasena(this);
    }
}
