package interbank.com.pe.exceptions;

public class IniciaError extends AssertionError {

    public static final String MESSAGE_FAILED_UPDATE = "The update password was not passed";
    public static final String MESSAGE_PASSED_WITHOUT_DNI = "Passed without dni";
    public static final String MESSAGE_FAILED_CODE = "Code Error";

    public IniciaError(String message, Throwable cause) {
        super(message, cause);
    }
}