package interbank.com.pe.questions.createaccount;

import interbank.com.pe.userinterfaces.createaccount.RevisaTuCorreo;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

/**
 * @author Yoselyn Cotrina
 */
public class MensajeExitoso {

    public static Question<String> reenvioCodigo() {
        return actor -> TextContent.of(RevisaTuCorreo.LBL_EXITOSO_REENVIO_CODIGO).viewedBy(actor).asString();
    }
}
