package interbank.com.pe.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EsperarElementoClickable implements Interaction {
    private final Target target;

    public EsperarElementoClickable(Target target) {
        this.target = target;
    }

    @Override
    @Step("{0} esperar el elemento")
    public <T extends Actor> void performAs(T actor) {
//        actor.attemptsTo(WaitUntil.the(target, isClickable()));
        target.resolveFor(actor).waitUntilClickable();
//        actor.attemptsTo(WaitUntil.the(target, isClickable()).forNoMoreThan(60).seconds());

    }

    public static EsperarElementoClickable in(Target target) {
        return instrumented(EsperarElementoClickable.class, target);
    }
}
