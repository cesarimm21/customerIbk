package interbank.com.pe.task.myaccount;

import interbank.com.pe.userinterfaces.myaccount.HomeMiCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

/**
 * @author Cesar Ilachoque
 */
public class ForgotPassword implements Task {

    @Step("Botón Olvidaste tu contraseña")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
//                Click.on(Login.BTN_INGRESARS)
                Click.on(HomeMiCuenta.BTN_FORGOT)
        );
    }
}

