package interbank.com.pe.task.login;

import interbank.com.pe.userinterfaces.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InputDocumento implements Task {

    private final String tipo;
    private final String numDoc;

    public InputDocumento(String tipo, String numDoc) {
        this.tipo = tipo;
        this.numDoc = numDoc;
    }

    public static Performable withData(String tipo, String numDoc) {
        return instrumented(InputDocumento.class, tipo, numDoc);
    }

    @Step("{0} {1} Ingresar datos de inicio de sesion")
    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(Login.OPEN_OPTIONS),
                Click.on(Login.LBL_SELECT.of(tipo).called(tipo)),
                Enter.theValue(numDoc).into(Login.INP_VALUE)
        );
    }
}
