package interbank.com.pe.task.login;

import interbank.com.pe.userinterfaces.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ButtonIngresar implements Task {

    @Step("Click en boton ingresar")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Login.BTN_INGRESAR_LOGIN)
        );
    }

}
