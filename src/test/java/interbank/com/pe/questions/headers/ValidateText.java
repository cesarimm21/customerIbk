package interbank.com.pe.questions.headers;

import interbank.com.pe.userinterfaces.Login;
import interbank.com.pe.userinterfaces.headers.HeadersPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class ValidateText {

    public static Question<String> zonaBotonInicio() {
        return actor -> Login.BTN_INICIA_SESION.resolveFor(actor).waitUntilVisible().getText();
    }

    public static Question<String> cintilloMessage() {
        return actor -> TextContent.of(HeadersPage.SPN_CINTILLO).viewedBy(actor).asString();
    }

    public static Question<String> millasMessage() {
        return actor -> TextContent.of(HeadersPage.SPN_MILLAS).viewedBy(actor).asString();
    }
    public static Question<String> errorMessage() {
        return actor -> TextContent.of(HeadersPage.SPN_MILLAS).viewedBy(actor).asString();
    }
}