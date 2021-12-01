package interbank.com.pe.task.myaccount;

import interbank.com.pe.userinterfaces.headers.HeadersPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

/**
 * @author Cesar Ilachoque
 */
public class MiCuenta implements Task {

    @Step("Ingresamos a mi cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HeadersPage.BTN_DROP_LOGIN),
                Click.on(HeadersPage.A_CUENTA)
        );
    }
}

