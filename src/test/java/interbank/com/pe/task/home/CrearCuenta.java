package interbank.com.pe.task.home;

import interbank.com.pe.userinterfaces.createaccount.TuCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

/**
 * @author Yoselyn Cotrina
 */
public class CrearCuenta implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrearCuenta.class);

    private final String tipo;
    private final String numDoc;

    public CrearCuenta(String tipo, String numDoc) {
        this.tipo = tipo;
        this.numDoc = numDoc;
    }

    @Step("{0} Ingresa datos paso 1 de Crear Cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipo) {
            case "DNI":
                actor.attemptsTo(
                        Click.on(TuCuenta.CBX_SELECCIONA_TIP_DOC),
                        Click.on(TuCuenta.CBX_TIPO_DOC_DNI),
                        WaitUntil.the(TuCuenta.TXT_NUM_DOC, isClickable()).forNoMoreThan(30).seconds(),
                        Enter.theValue(numDoc).into(TuCuenta.TXT_NUM_DOC),
                        Click.on(TuCuenta.BTN_CONTINUAR)
                );
                break;
            case "CE":
                actor.attemptsTo(
                        Click.on(TuCuenta.CBX_SELECCIONA_TIP_DOC),
                        Click.on(TuCuenta.CBX_TIPO_DOC_CE),
                        Enter.theValue(numDoc).into(TuCuenta.TXT_NUM_DOC),
                        Click.on(TuCuenta.BTN_CONTINUAR)
                );
                break;
            case "PASS":
                actor.attemptsTo(
                        Click.on(TuCuenta.CBX_SELECCIONA_TIP_DOC),
                        Click.on(TuCuenta.CBX_TIPO_DOC_PASS),
                        Enter.theValue(numDoc).into(TuCuenta.TXT_NUM_DOC),
                        Click.on(TuCuenta.BTN_CONTINUAR)
                );
                break;
            case "Selecciona":
                actor.attemptsTo(
                        Click.on(TuCuenta.CBX_SELECCIONA_TIP_DOC),
                        Click.on(TuCuenta.CBX_TIPO_DOC_SELECIONA),
                        Enter.theValue(numDoc).into(TuCuenta.TXT_NUM_DOC),
                        Click.on(TuCuenta.BTN_CONTINUAR)
                );
                break;
            default:
                LOGGER.info("No selecciona tipo de documento !!!");
        }
    }

    public static Performable withData(String tipo, String numDoc) {
        return instrumented(CrearCuenta.class, tipo, numDoc);
    }

}


