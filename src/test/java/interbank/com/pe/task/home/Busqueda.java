package interbank.com.pe.task.home;

import interbank.com.pe.userinterfaces.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Yoselyn Cotrina
 */
public class Busqueda implements Task {

    private final String nomProduct;
    private final String mundo;

    public Busqueda(String nomProduct, String mundo) {
        this.nomProduct = nomProduct;
        this.mundo = mundo;
    }

    public static Performable is(String nomProduct, String mundo) {
        return instrumented(Busqueda.class, nomProduct, mundo);
    }

    @Step("{0} Busca el #titulo en el #mundo")
    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (mundo) {
            case "Productos":
                WaitUntil.the(Home.TXT_BUSCADOR, isVisible()).forNoMoreThan(80).seconds();
                actor.attemptsTo(
                        Enter.theValue(nomProduct).into(Home.TXT_BUSCADOR),
                        Hit.the(Keys.ARROW_DOWN).into(Home.TXT_BUSCADOR),
                        Hit.the(Keys.ENTER).into(Home.TXT_BUSCADOR)
                );
                break;
            case "Vales de Consumo":
                WaitUntil.the(Home.BTN_BUSQUEDA_VALE, isVisible()).forNoMoreThan(80).seconds();
                actor.attemptsTo(
                        Click.on(Home.BTN_BUSQUEDA_VALE),
                        Enter.theValue(nomProduct).into(Home.TXT_BUSCADOR),
                        Hit.the(Keys.ARROW_DOWN).into(Home.TXT_BUSCADOR),
                        Hit.the(Keys.ENTER).into(Home.TXT_BUSCADOR)
                );
        }
    }

}
