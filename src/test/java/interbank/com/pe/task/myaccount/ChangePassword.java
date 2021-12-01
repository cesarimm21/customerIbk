package interbank.com.pe.task.myaccount;

import interbank.com.pe.userinterfaces.myaccount.HomeMiCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * @author Cesar Ilachoque
 */
public class ChangePassword implements Task {

    private final String password;

    public ChangePassword(String password) {
        this.password = password;
    }

    public static Performable withData(String password) {
        return instrumented(ChangePassword.class, password);
    }

    @Step("{0} Ingresamos nueva contraseña")
    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(password).into(HomeMiCuenta.INP_PASSWORD_01),
                Enter.theValue(password).into(HomeMiCuenta.INP_PASSWORD_02),
                Click.on(HomeMiCuenta.BTN_SAVE)
        );
    }
}

