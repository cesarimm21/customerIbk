package interbank.com.pe.task.myaccount;

import interbank.com.pe.userinterfaces.myaccount.HomeMiCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * @author Cesar Ilachoque
 */
public class InputValue implements Task {

    private final String codigo;

    public InputValue(String codigo) {
        this.codigo = codigo;
    }

    public static Performable withData(String codigo) {
        return instrumented(InputValue.class, codigo);
    }

    @Step("{0} Ingresamos código")
    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(codigo).into(HomeMiCuenta.INP_CODIGO)
        );
    }
}

