package interbank.com.pe.questions.createaccount;

import interbank.com.pe.userinterfaces.createaccount.Contrasenas;
import interbank.com.pe.userinterfaces.createaccount.RevisaTuCorreo;
import interbank.com.pe.userinterfaces.createaccount.TuCuenta;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.thucydides.core.annotations.Step;

/**
 * @author Yoselyn Cotrina
 */
public class ElTitulo {

    @Step("Validación del titulo")
    public static Question<String> cuenta() {
        return actor -> TuCuenta.LBL_TITULO.resolveFor(actor).waitUntilVisible().getText();
    }

    @Step("Validación del titulo")
    public static Question<String> contrasena() {
        return actor -> TextContent.of(Contrasenas.LBL_TITULO).viewedBy(actor).asString();
    }

    @Step("Validación de pagina")
    public static Question<String> TerminosCondiciones() {
        return actor -> TextContent.of(Contrasenas.LBL_TITULO_POPUP).viewedBy(actor).asString();
    }

    @Step("Validación de pagina")
    public static Question<String> PoliticasSeguridad() {
        return actor -> TextContent.of(Contrasenas.LBL_TITULO).viewedBy(actor).asString();
    }

    @Step("Validación del titulo")
    public static Question<String> correo() {
        return actor -> TextContent.of(RevisaTuCorreo.LBL_TITULO).viewedBy(actor).asString();
    }

    @Step("Validación del titulo")
    public static Question<String> actualizaCorreo() {
        return actor -> TextContent.of(RevisaTuCorreo.TBL_ACTUALIZA_CORREO).viewedBy(actor).asString();
    }
}
