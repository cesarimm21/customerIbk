package interbank.com.pe.task.createaccount;

import interbank.com.pe.interactions.EsperarElementoVisible;
import interbank.com.pe.userinterfaces.createaccount.Contrasenas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Yoselyn Cotrina
 */
public class CrearContrasena implements Task {

    private final String contrasena;
    private final String recontrasena;
    private final String terminos;
    private final String politicas;

    public CrearContrasena(String contrasena, String recontrasena, String terminos, String politicas) {
        this.contrasena = contrasena;
        this.recontrasena = recontrasena;
        this.terminos = terminos;
        this.politicas = politicas;
    }

    @Step("{0} Ingresa datos paso 2 de Crear Contraseña")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(Contrasenas.TXT_CONTRASENA, isVisible()).forNoMoreThan(60).seconds(),
                EsperarElementoVisible.in(Contrasenas.TXT_CONTRASENA),
                Enter.theValue(contrasena).into(Contrasenas.TXT_CONTRASENA),
                Enter.theValue(recontrasena).into(Contrasenas.TXT_RECONTRASENA)
        );

        if (terminos.equals("SI")) {
            actor.attemptsTo(
                    Click.on(Contrasenas.CHX_TERMINOS_CONDICIONES)
            );
            System.out.println("Ingresa aqui terminos.SI" + "btnconinuar" + Contrasenas.BTN_CONTINUAR);
        } else {
            actor.attemptsTo(
                    Click.on(Contrasenas.BTN_CONTINUAR),
                    WaitUntil.the(Contrasenas.BTN_CONTINUAR, isVisible()).forNoMoreThan(60).seconds()
            );
        }
        if (politicas.equals("SI")) {
            actor.attemptsTo(
                    Click.on(Contrasenas.CHX_POLITICAS_PRIVACIDAD),
                    Click.on(Contrasenas.BTN_CONTINUAR)
            );
        } else {
            actor.attemptsTo(
                    Click.on(Contrasenas.BTN_CONTINUAR),
                    WaitUntil.the(Contrasenas.BTN_CONTINUAR, isVisible()).forNoMoreThan(60).seconds()
            );
        }
    }

    public static Performable withData(String contrasena, String recontrasena, String terminos, String politicas) {
        return instrumented(CrearContrasena.class, contrasena, recontrasena, terminos, politicas);

    }

}
