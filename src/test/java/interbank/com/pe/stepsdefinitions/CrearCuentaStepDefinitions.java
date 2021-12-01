package interbank.com.pe.stepsdefinitions;

import interbank.com.pe.questions.ValidacionLogueo;
import interbank.com.pe.questions.createaccount.ElTitulo;
import interbank.com.pe.questions.createaccount.MensajeError;
import interbank.com.pe.questions.createaccount.MensajeExitoso;
import interbank.com.pe.task.createaccount.CrearContrasena;
import interbank.com.pe.task.home.CrearCuenta;
import interbank.com.pe.userinterfaces.Home;
import interbank.com.pe.userinterfaces.Login;
import interbank.com.pe.userinterfaces.createaccount.Contrasenas;
import interbank.com.pe.userinterfaces.createaccount.RevisaTuCorreo;
import interbank.com.pe.userinterfaces.createaccount.TuCuenta;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Yoselyn Cotrina
 */
public class CrearCuentaStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("inicia el proceso de crear cuenta")
    public void iniciaProcesoCrearCuenta() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Home.BTN_CREAR_CUENTA, isVisible()).forNoMoreThan(160).seconds(),
                Click.on(Home.BTN_CREAR_CUENTA)
        );
    }

    @Then("visualiza la pagina de registro")
    public void visualizaPaginaRegistro() {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-login");
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TuCuenta.LBL_TITULO, isVisible()).forNoMoreThan(100).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("El título", ElTitulo.cuenta(), equalToIgnoringWhiteSpace("Crea tu cuenta"))
        );
    }

    //Se usa para validación en Login
    @Then("visualiza la pagina de Crear Cuenta")
    public void visualizaPaginaCrearCuenta() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TuCuenta.LBL_TITULO, isVisible()).forNoMoreThan(20).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("El título", ElTitulo.cuenta(), equalToIgnoringWhiteSpace("Crea tu cuenta"))
        );
    }

    @When("ingresa a Tienes una cuenta Inicia sesion")
    public void ingresaTienesCuentaIniciaSesion() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(TuCuenta.BTN_INICIASESION)
        );
    }

    @Then("visualiza la pagina de Login")
    public void visualizaPaginaLogin() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Login.LBL_TITULO, isVisible()).forNoMoreThan(35).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("El título", ValidacionLogueo.title(), equalTo(" Inicia sesión "))
        );
    }

    @When("^ingresa sus datos :  (.*), (.*)$")
    public void ingresaTipoNumeroDocumento(String tipo, String numDoc) {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-login");
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TuCuenta.LBL_TITULO, isVisible()).forNoMoreThan(35).seconds()
        );
        theActorInTheSpotlight().attemptsTo(
                CrearCuenta.withData(tipo, numDoc)
        );
    }

    @Then("se visualiza la pagina de paso 2 Crea una contraseña")
    public void visualizaPaginaPaso2CreaUnaContrasena() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Contrasenas.LBL_TITULO, isVisible()).forNoMoreThan(100).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("El título", ElTitulo.contrasena(), equalToIgnoringWhiteSpace("Crea una contraseña"))
        );
    }

    @Then("^se muestra el mensaje (.*) para el campo(.*) al empezar el registro$")
    public void muestraMensajeCampoEmpezarRegistro(String msjError, String campo) {
        theActorInTheSpotlight().should(
                seeThat("Mensaje de validación", MensajeError.cuenta(campo), containsString(msjError))
        );
    }

    @And("^crea una contraseña : contraseña (.*) su confirmacion (.*), acepta uso de terminos y condiciones (.*) y autotizo politicas de privacidad (.*)$")
    public void validaCreaClave(String contrasena, String recontrasena, String datosPer, String terminos) {
        theActorInTheSpotlight().attemptsTo(
                CrearContrasena.withData(contrasena, recontrasena, datosPer, terminos)
        );
    }

    @Then("se visualiza la pagina de paso 3 Revisa tu correo")
    public void visualizaPaginaPaso3RevisaTuCorreo() {
        WaitUntil.the(RevisaTuCorreo.LBL_TITULO, isVisible()).forNoMoreThan(4000).seconds();
        theActorInTheSpotlight().should(
                seeThat("El título", ElTitulo.correo(), equalToIgnoringWhiteSpace("Revisa tu correo"))
        );
    }

    @Then("^se muestra el siguiente mensaje (.*) en el (.*) al continuar el paso 3$")
    public void muestraSiguienteMensajeContinuarPaso3(String msj_error, String campo) {
        System.out.println("campo)" + campo + " error :" + msj_error);
        theActorInTheSpotlight().should(
                seeThat("Mensaje de validación", MensajeError.contrasena(campo), equalToIgnoringWhiteSpace(msj_error))
        );

    }

    @And("ingresa a terminos y condiciones")
    public void ingresaTerminosYCondiciones() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Contrasenas.LBL_TITULO, isVisible()).forNoMoreThan(50).seconds()
        );
        theActorInTheSpotlight().attemptsTo(
                Click.on(Contrasenas.LNK_TERMINOS_CONDICIONES)
        );
    }

    @Then("se visualiza la ventana de Términos y condiciones del programa")
    public void visualizaVentanaTerminosYCondicionesDelPrograma() {
        theActorInTheSpotlight().should(
                seeThat("El título", ElTitulo.TerminosCondiciones(), containsString("Términos y condiciones del programa de lealtad Interbank Benefit"))
        );
    }

    @When("selecciona entendido")
    public void seleccionaEntendido() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(Contrasenas.BTN_ENTENDIDO)
        );
    }

    @When("ingresa a Politicas de seguridad")
    public void ingresaPoliticasSeguridad() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(Contrasenas.LNK_DATOS_PERSONALES)
        );
    }

    @Then("se visualizala ventana de Politicas de seguridad")
    public void visualizaVentanaPoliticasSeguridad() {
        theActorInTheSpotlight().should(
                seeThat("El título", ElTitulo.PoliticasSeguridad(), equalTo(" Politicas de Seguridad "))
        );
    }

    @When("retroce a la pagina anterior")
    public void retrocePaginaAnterior() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(Contrasenas.BTN_RETROCEDER)
        );
    }

    @And("^revisa tu correo : ingresa el codigo otp (.*)$")
    public void ingresaCodigoOtp(String codigo) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(RevisaTuCorreo.TXT_CODIGO, isVisible()).forNoMoreThan(700).seconds()
        );
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(codigo).into(RevisaTuCorreo.TXT_CODIGO)
        );
    }

    @Then("^se muestra el mensaje de error (.*)$")
    public void muestraElMensajeDeError(String msj_mensaje) {
        theActorInTheSpotlight().should(
                seeThat("mensaje de error", MensajeError.codigo(), equalToIgnoringWhiteSpace(msj_mensaje))
        );
    }

    @Then("^se muestra mensaje de error back (.*)$")
    public void muestraMensajeErrorBack(String msj_error) {
        theActorInTheSpotlight().should(
                seeThat("mensaje de error", MensajeError.codigo(), equalToIgnoringWhiteSpace(msj_error))
        );
    }

    @When("selecciona el enlace ¿Haz cambiado de correo?")
    public void seleccionaEnlaceHazCambiadoCorreo() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(RevisaTuCorreo.LNK_CAMBIO_CORREO)
        );
    }

    @Then("se visualiza ventana con información cambio de correo por Banca Telefonica")
    public void visualizaVentanaInformacionCambioCorreoPorBancaTelefonica() {
        theActorInTheSpotlight().should(
                seeThat("El título", ElTitulo.actualizaCorreo(), equalToIgnoringWhiteSpace("Actualiza tu correo en tu Banca por Internet"))
        );
    }

    @When("cierra la ventana de información")
    public void cierraVentanaInformacion() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(RevisaTuCorreo.BTN_CERRAR)
        );
    }

    @When("selecciona el enlace volver a enviar")
    public void seleccionaEnlaceVolverEnviar() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(RevisaTuCorreo.LNK_VOLVER_ENVIAR)
        );
    }

    @Then("^se visualiza mensaje de confirmacion (.*)$")
    public void visualizaMensajeConfirmacion(String msj) {
        theActorInTheSpotlight().should(
                seeThat("mensaje exitoso", MensajeExitoso.reenvioCodigo(), equalToIgnoringWhiteSpace(msj))
        );
    }

    @When("selecciono el enlace Retroceder")
    public void seleccionoEnlaceRetroceder() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(RevisaTuCorreo.BTN_RETROCEDER)
        );
    }

    @And("selecciona la opcion crear cuenta")
    public void seleccionaOpcionCrearCuenta() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(RevisaTuCorreo.BTN_CREAR_CUENTA)
        );
    }

    @Then("^se valida que el cliente tiene (.*) millas$")
    public void validaConsultadoMillas(String miles) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Home.MILLAS_HOME2, isVisible()).forNoMoreThan(5000).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("Millas", ValidacionLogueo.miles(), equalTo(miles))
        );
    }

}
