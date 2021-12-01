package interbank.com.pe.task.myaccount;

import interbank.com.pe.userinterfaces.myaccount.InformacionPersonal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @author Yoselyn Cotrina
 */
public class CarmbiarCelular implements Task {

    // private final String operador;
    private final String numero;

    public CarmbiarCelular(String numero) {
        //   this.operador = operador;
        this.numero = numero;
    }

    public static Performable withData(String numero) {
        return instrumented(CarmbiarCelular.class, numero);
    }

    @Step("{0} Ingresar datos para el cambio de número de celular")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(InformacionPersonal.TXT_NUMERO_CELULAR),
                Enter.theValue(numero).into(InformacionPersonal.TXT_NUMERO_CELULAR));
    }
}

