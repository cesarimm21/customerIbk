package interbank.com.pe.task.myaccount;

import interbank.com.pe.userinterfaces.myaccount.HomeMiCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

/**
 * @author Cesar Ilachoque
 */
public class OptionsUpdate implements Task {

    @Step("Botón actualizar")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeMiCuenta.BTN_ACTUALIZAR)
        );
    }
}

