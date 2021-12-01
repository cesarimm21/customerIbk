package interbank.com.pe.task;

import interbank.com.pe.interactions.EsperarElementoClickable;
import interbank.com.pe.interactions.SeleccionarOpcion;
import interbank.com.pe.userinterfaces.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.awaitility.Awaitility.await;

public class IngresarOpcionUsuario implements Task {

    private final String value;
    private final Target filters;

    public IngresarOpcionUsuario(String value, Target filters) {
        this.value = value;
        this.filters = filters;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarElementoClickable.in(Home.BUTTON_USUARIO)
        );
        await().forever().pollInterval(3, SECONDS).until(isNotNull(Home.BUTTON_USUARIO.resolveFor(actor)));
//                , Click.on(BUTTON_USUARIO)
        Home.BUTTON_USUARIO.resolveFor(actor).click();
        actor.attemptsTo(SeleccionarOpcion.por(filters, value));
    }

    public static IngresarOpcionUsuario miCuenta() {
        return instrumented(IngresarOpcionUsuario.class, "Mi cuenta", Home.OPTION_MICUENTA);
    }

    private Callable<Boolean> isNotNull(WebElement element) {
        return () -> element != null;
    }

    //PUEDES CREAR OTRO METODO PARA:
    // - VER MI CANJE
    // - PARA CERRAR SESION
}
