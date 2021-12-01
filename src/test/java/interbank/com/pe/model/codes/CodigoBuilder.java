package interbank.com.pe.model.codes;


import interbank.com.pe.exceptions.CodigoException;
import interbank.com.pe.model.Codigo;
import interbank.com.pe.utils.builders.Builder;

public class CodigoBuilder implements Builder<Codigo> {

    private final String code;

    public CodigoBuilder(String code) {
        this.code = code;
    }

    public static CodigoBuilder code(String code) {
        return new CodigoBuilder(code);
    }

    public String getCode() {
        return code;
    }

    @Override
    public Codigo build() throws CodigoException {
        return new Codigo(this);
    }
}
