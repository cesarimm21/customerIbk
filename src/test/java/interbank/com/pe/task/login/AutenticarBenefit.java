package interbank.com.pe.task.login;

import interbank.com.pe.interactions.EsperarElementoVisible;
import interbank.com.pe.interactions.SeleccionarOpcion;
import interbank.com.pe.model.ContrasenaLogin;
import interbank.com.pe.model.Documento;
import interbank.com.pe.userinterfaces.Login;
import interbank.com.pe.utils.builders.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AutenticarBenefit implements Task {
    private final String value;
    private final Target lisFilters;
    private final Documento document;
    private final ContrasenaLogin password;

    public AutenticarBenefit(String value, Target lisFilters, Documento document, ContrasenaLogin password) {
        this.value = value;
        this.lisFilters = lisFilters;
        this.document = document;
        this.password = password;
    }

    @Override
    @Step("{0} autenticar benefit")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EsperarElementoVisible.in(Login.NUMBER_DOCUMENT_LOGIN)
                , Click.on(Login.TYPE_DOCUMENT_LOGIN)
                , SeleccionarOpcion.por(lisFilters, value)
                , Enter.theValue(document.getDocument()).into(Login.NUMBER_DOCUMENT_LOGIN)
                , Enter.theValue(password.getPassword()).into(Login.PASSWORD_LOGIN)
        );
    }

    public static AutenticarBenefit accesoBenefit(String value, Builder<Documento> builder, Builder<ContrasenaLogin> builder1) {
        return instrumented(AutenticarBenefit.class, value, Login.SELECT_TYPE_DOCUMENT_LOGIN, builder.build(), builder1.build());
    }

}
