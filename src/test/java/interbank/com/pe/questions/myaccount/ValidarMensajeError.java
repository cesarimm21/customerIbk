package interbank.com.pe.questions.myaccount;

import interbank.com.pe.userinterfaces.myaccount.InformacionPersonal;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class ValidarMensajeError {

    public static Question<String> NumeroCelular(int num) {
        Question mensajeError = null;
        if (num == 1) {
            mensajeError = actor -> TextContent.of(InformacionPersonal.LBL_ERROR_INCOMPLETO).viewedBy(actor).asString();
        } else {
            mensajeError = actor -> TextContent.of(InformacionPersonal.LBL_ERROR_VACIO).viewedBy(actor).asString();
        }
        return mensajeError;
    }

}
