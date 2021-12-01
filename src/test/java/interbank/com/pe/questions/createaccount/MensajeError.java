package interbank.com.pe.questions.createaccount;

import interbank.com.pe.userinterfaces.createaccount.Contrasenas;
import interbank.com.pe.userinterfaces.createaccount.RevisaTuCorreo;
import interbank.com.pe.userinterfaces.createaccount.TuCuenta;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Yoselyn Cotrina
 */
public class MensajeError {

    public static Question<String> contrasena(String campo) {
        Question mensajeError = null;
        if (campo.equals("contrasena")) {
            mensajeError = actor -> TextContent.of(Contrasenas.LBL_CONTRASENA_ERROR).viewedBy(actor).asString();
        } else if (campo.equals("recontrasena")) {
            WebElementQuestion.the(Contrasenas.LBL_RECONTRASENA_ERROR);
            WebElementStateMatchers.isVisible();
            mensajeError = actor -> TextContent.of(Contrasenas.LBL_RECONTRASENA_ERROR).viewedBy(actor).asString();
        } else {
            System.out.println("No hay validaciones");
        }
        return mensajeError;

    }

    public static Question cuenta(String campo) {
        Question mensajeValidacion = null;
        String campos = campo.trim();
        switch (campos) {
            case "tipo":
                WaitUntil.the(TuCuenta.LBL_TIPO_ERROR, isVisible()).forNoMoreThan(40).seconds();
                mensajeValidacion = Question.about("Mensaje de validación Tipo de Documento")
                        .answeredBy(
                                actor -> TextContent.of(TuCuenta.LBL_TIPO_ERROR).viewedBy(actor).asString()
                        );
                break;
            case "numDoc":
                WaitUntil.the(TuCuenta.LBL_NUM_DOC_ERROR, isVisible()).forNoMoreThan(40).seconds();
                mensajeValidacion = Question.about("Mensaje de validación Número de documento")
                        .answeredBy(
                                actor -> TextContent.of(TuCuenta.LBL_NUM_DOC_ERROR).viewedBy(actor).asString()
                        );
                break;
        }
        return mensajeValidacion;
    }

    public static Question<String> codigo() {
        return actor -> TextContent.of(RevisaTuCorreo.LBL_CODIGO_ERROR).viewedBy(actor).asString();
    }

}
