package interbank.com.pe.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EsperarElementoVisible implements Interaction {

    private final Target target;

    public EsperarElementoVisible(Target target) {
        this.target = target;
    }

    @Override
    @Step("{0} wait for element")
    public <T extends Actor> void performAs(T actor) {
//        actor.attemptsTo(WaitUntil.the(target, isVisible()));
//        target.resolveFor(actor).waitUntilVisible();
        actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(60).seconds());
    }

    public static EsperarElementoVisible in(Target target) {
        return instrumented(EsperarElementoVisible.class, target);
    }
}

