package interbank.com.pe.task;

import interbank.com.pe.interactions.EsperarElementoVisible;
import interbank.com.pe.userinterfaces.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.awaitility.Awaitility.await;

public class IngresarPaginaLogin implements Task {

    @Override
    @Step("{0} ingresa a la pagina de login")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EsperarElementoVisible.in(Home.BUTTON_LOGIN));
        await().forever().pollInterval(2, SECONDS).until(isNotNull(Home.BUTTON_USUARIO.resolveFor(actor)));
        Home.BUTTON_LOGIN.resolveFor(actor).click();
    }

    public static IngresarPaginaLogin in() {
        return instrumented(IngresarPaginaLogin.class);
    }

    private Callable<Boolean> isNotNull(WebElement element) {
        return () -> element != null;
    }

}
