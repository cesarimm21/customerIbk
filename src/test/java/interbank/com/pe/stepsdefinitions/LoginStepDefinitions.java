package interbank.com.pe.stepsdefinitions;

import cucumber.api.java.Before;
import interbank.com.pe.interactions.EsperarElementoVisible;
import interbank.com.pe.questions.ValidacionLogueo;
import interbank.com.pe.questions.ValidacionUrl;
import interbank.com.pe.questions.createaccount.ElTitulo;
import interbank.com.pe.task.AbrirBenefit;
import interbank.com.pe.task.IngresarPaginaLogin;
import interbank.com.pe.task.login.AutenticarBenefit;
import interbank.com.pe.task.login.ButtonIngresar;
import interbank.com.pe.task.login.ButtonIniciaSesion;
import interbank.com.pe.userinterfaces.Home;
import interbank.com.pe.userinterfaces.Login;
import interbank.com.pe.userinterfaces.createaccount.TuCuenta;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static interbank.com.pe.model.passwords.ContrasenaLoginBuilder.password;
import static interbank.com.pe.model.documents.DocumentoBuilder.document;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que el (.*) esta en iframe de iniciar sesion de benefit$")
    public void usuarioIniciaSesionBenefit(String usuario) {
        theActorCalled(usuario).attemptsTo(
                AbrirBenefit.theLoginBenefitPage()
        );
    }
    @And("selecciona la opcion inicia sesion")
    public void seleccionarOpcionIniciaSesion() {
        theActorInTheSpotlight().attemptsTo(
                new ButtonIniciaSesion()
        );
    }
    //PARTE LOGIN
    @And("^el selecciona el tipo de documento (.*) e ingresa numero de documento (.*) y contrasena (.*)$")
    public void elSeleccionaElTipoDeDocumentoEIngresaNumeroDeDocumentoYContrasena(String tipo, String documento, String contrasena) {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-login");
        theActorInTheSpotlight().attemptsTo(
                AutenticarBenefit.accesoBenefit(tipo, document(documento), password(contrasena))
        );
    }
    @And("^el presiona el boton ingresar$")
    public void elPresionaElBotonIngresar() {
        theActorInTheSpotlight().attemptsTo(
                new ButtonIngresar()
        );
    }
    @Then("^valida que el cliente tiene (.*) millas$")
    public void validaClienteTieneMillas(String miles) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Home.MILLAS_HOME2, isVisible()).forNoMoreThan(100).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("Validación de millas",ValidacionLogueo.miles(), containsString(miles))
        );
    }
    @Then("^el visualiza el error back (.*)$")
    public void elVisualizaElErrorBack(String error) {
        theActorInTheSpotlight().should(
                seeThat(ValidacionLogueo.back(), containsString(error))
        );
    }
    @Then("^el muestra un mensaje debajo de documento (.*)$")
    public void elMuestraUnMensajeDebajoDeDocumento(String label) {
        theActorInTheSpotlight().should(seeThat(ValidacionLogueo.usuario(), containsString(label)));
    }
    @Then("^el muestra un mensaje debajo de contrasena (.*)$")
    public void elMuestraUnMensajeDebajoDeContrasena(String label) {
        theActorInTheSpotlight().should(seeThat(ValidacionLogueo.contrasena(), containsString(label)));
    }
    @When("^el selecciona el enlace Crear Cuenta$")
    public void elSeleccionaElEnlaceCrearCuenta() {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-login");
        theActorInTheSpotlight().attemptsTo(EsperarElementoVisible.in(Login.LINK_CREAR_CUENTA)
                , Click.on(Login.LINK_CREAR_CUENTA));
    }
    @Given("^que el (.*) se encuentra en la url (.*)$")
    public void queElUsuarioSeEncuentraEnLaUrl(String name, String url) {
        theActorCalled(name).wasAbleTo(Open.url(url));
    }

    @And("^el ingresa a la pantalla de login$")
    public void elIngresaALaPantallaDeLogin() {
        theActorInTheSpotlight().attemptsTo(IngresarPaginaLogin.in());
    }

    @When("^el selecciona el enlace retroceder$")
    public void elSeleccionaElEnlaceRetroceder() {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-login");
        theActorInTheSpotlight().attemptsTo(EsperarElementoVisible.in(Login.LINK_RETROCEDER), Click.on(Login.LINK_RETROCEDER));
    }

    @Then("^el valida que se regresa a la url anterior (.*)")
    public void elValidaQueSeRegresaALaUrlAnteriorUrl(String href) {
        theActorInTheSpotlight().should(seeThat(ValidacionUrl.url(), equalTo(href)));
    }

}
