package interbank.com.pe.model;

import interbank.com.pe.model.codes.CodigoBuilder;

public class Codigo {

    private final String code;

    public Codigo(CodigoBuilder builder) {
        this.code = builder.getCode();
    }

    public String getCode() {
        return code;
    }

}
