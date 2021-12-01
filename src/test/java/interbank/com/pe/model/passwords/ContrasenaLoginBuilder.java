package interbank.com.pe.model.passwords;

import interbank.com.pe.exceptions.ContrasenaException;
import interbank.com.pe.model.ContrasenaLogin;
import interbank.com.pe.utils.builders.Builder;

public class ContrasenaLoginBuilder implements Builder<ContrasenaLogin> {

    private String password;

    public ContrasenaLoginBuilder(String password) {
        this.password = password;
    }

    public static ContrasenaLoginBuilder password(String password) {
        return new ContrasenaLoginBuilder(password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public ContrasenaLogin build() throws ContrasenaException {
        return new ContrasenaLogin(this);
    }
}
