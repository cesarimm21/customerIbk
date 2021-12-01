package interbank.com.pe.questions;

import interbank.com.pe.userinterfaces.Home;
import interbank.com.pe.userinterfaces.Login;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.thucydides.core.annotations.Step;

/**
 * @author Yoselyn Cotrina
 */
public class ValidacionLogueo {

    @Step("Validación pagina de Login")
    public static Question<String> title() {
        return actor -> TextContent.of(Login.LBL_TITULO).viewedBy(actor).asString();
    }

    public static Question<String> miles() {
        return actor -> TextContent.of(Home.MILLAS_HOME2).viewedBy(actor).asString();
    }

    public static Question<String> usuario() {
        return actor -> Login.LABEL_ERROR_DOCUMENTO.resolveFor(actor).waitUntilVisible().getText();
    }

    public static Question<String> contrasena() {
        return actor -> Login.LABEL_ERROR_PASSWORD.resolveFor(actor).waitUntilVisible().getText();
    }

    public static Question<String> back() {
        return actor -> Login.LABEL_ERROR_BACK.resolveFor(actor).waitUntilVisible().getText();
    }
    public static Question<String> nameHome() {
        return actor -> TextContent.of(Home.MILLAS_HOME3).viewedBy(actor).asString();
    }
}
