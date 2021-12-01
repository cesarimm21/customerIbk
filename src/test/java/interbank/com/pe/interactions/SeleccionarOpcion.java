package interbank.com.pe.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarOpcion implements Interaction {

    private final String value;
    private final Target target;

    public SeleccionarOpcion(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    @Override
    @Step("{0} Filtered by #value and click on the resulting item")
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elementList = target.resolveAllFor(actor);
        for (WebElementFacade elementFacade : elementList) {
            if (elementFacade.getText().equals(value)) {
                elementFacade.click();
                break;
            }
        }
    }

    public static SeleccionarOpcion por(Target target, String value) {
        return instrumented(SeleccionarOpcion.class, target, value);
    }
}
