package interbank.com.pe.stepsdefinitions;

import interbank.com.pe.interactions.EsperarElementoVisible;
import interbank.com.pe.questions.ValidacionLogueo;
import interbank.com.pe.questions.headers.ValidateText;
import interbank.com.pe.questions.myaccount.ValidarTexto;
import interbank.com.pe.task.IngresarOpcionUsuario;
import interbank.com.pe.task.login.InputDocumento;
import interbank.com.pe.task.myaccount.*;
import interbank.com.pe.userinterfaces.Home;
import interbank.com.pe.userinterfaces.createaccount.Contrasenas;
import interbank.com.pe.userinterfaces.headers.HeadersPage;
import interbank.com.pe.userinterfaces.myaccount.HomeMiCuenta;
import interbank.com.pe.userinterfaces.myaccount.InformacionPersonal;
import interbank.com.pe.userinterfaces.myaccount.InicioSesionYSeguridad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class MiCuentaStepDefinitions {
    @Then("verificamos que estemos en la pagina de inicio con login")
    public void verifPageInicio() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HeadersPage.SPN_MILLAS, isVisible()).forNoMoreThan(100).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("texto de inicio", ValidateText.millasMessage(), containsString("Millas Benefit"))
        );
    }
    @Given("^que el usuario ingresa a Mi Cuenta para verificar su información$")
    public void miCuenta() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HeadersPage.BTN_DROP_LOGIN, isVisible()).forNoMoreThan(100).seconds()
        );
        theActorInTheSpotlight().attemptsTo(
                new MiCuenta()
        );
    }
    @When("^el selecciona la opcion de Inicio de sesion y seguridad$")
    public void elSeleccionaLaOpcionDeInicioDeSesionYSeguridad() {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-perfil");
        theActorInTheSpotlight().attemptsTo(
                EsperarElementoVisible.in(HomeMiCuenta.NOMBRE_USUARIO)
        );
        theActorInTheSpotlight().attemptsTo(
                EsperarElementoVisible.in(HomeMiCuenta.SECCION_SESION_Y_SEGURIDAD),
                JavaScriptClick.on(HomeMiCuenta.SECCION_SESION_Y_SEGURIDAD)
        );
    }
    @Given("^verificamos la pagina de (.*)$")
    public void verificPage(String title) {
        theActorInTheSpotlight().should(
                seeThat("El titulo de la pagina", ValidarTexto.textTittle(), containsString(title))
        );
    }
    @Given("^selecionamos la opcion de actualizar$")
    public void optionsActualizar() {
        theActorInTheSpotlight().attemptsTo(
                new OptionsUpdate()
        );
    }

    @Given("^ingresamos la nueva contraseña (.*)$")
    public void newPassword(String password) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomeMiCuenta.BTN_SAVE, isPresent()).forNoMoreThan(60).seconds()
        );
        theActorInTheSpotlight().attemptsTo(
                ChangePassword.withData(password));
    }
    @Given("^verificamos el mensaje para ingresar el código e ingresamos el código (.*)$")
    public void messageAndCodigo(String codigo) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomeMiCuenta.LBL_TITLE_SUB, isPresent()).forNoMoreThan(60).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("El titulo de la pagina", ValidarTexto.textTittleLast(), equalTo(" Ingresa el código para guardar el cambio "))
        );
        theActorInTheSpotlight().attemptsTo(
                InputValue.withData(codigo)
        );
        theActorInTheSpotlight().attemptsTo(
                new OptionsSave()
        );
    }
    @Given("^el valida el mensaje (.*) de confirmación de cambio contraseña$")
    public void validateSms(String mensaje) {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomeMiCuenta.BTN_SUCCESS, isPresent()).forNoMoreThan(60).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("M", ValidarTexto.textSuccess(), containsString(mensaje))
        );

    }
    @Given("^selecciona la opcion de Olvidaste tu contraseña$")
    public void optionsForgotPassword() {
        theActorInTheSpotlight().attemptsTo(
                new ForgotPassword()
        );
    }
    @And("^selecciona el tipo de documento (.*) e ingresa numero de documento (.*)$")
    public void tipeDocument(String tipo, String documento) {
        theActorInTheSpotlight().attemptsTo(
                InputDocumento.withData(tipo, documento)
        );
    }
    @Given("^seleccionamos la opcion continuar$")
    public void optionsContinuar() {
        theActorInTheSpotlight().attemptsTo(
                new OptionsContinuar()
        );
    }
    @Given("^el verifica el mensaje para revisa tu correo e ingresamos el código (.*)$")
    public void messageBuzon(String codigo) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomeMiCuenta.LBL_TITLE_SUB2, isPresent()).forNoMoreThan(60).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("El titulo de la pagina", ValidarTexto.textTittleBuzon(), equalTo(" Restablece tu contraseña "))
        );
        theActorInTheSpotlight().attemptsTo(
                InputValue.withData(codigo)
        );
        theActorInTheSpotlight().attemptsTo(
                new OptionsSave2()
        );
    }
    @Then("^validamos el mensaje de (.*)$")
    public void validateMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de error es", ValidarTexto.errorMessage(), containsString(message))
        );
    }
    @Then("^validamos los mensajes de error (.*) de nueva contraseña y mensaje (.*) de repita contraseña$")
    public void validateMessage2(String message, String messageRepite) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de error es", ValidarTexto.errorMessage(), containsString(message)),
                seeThat("El mensaje de error es", ValidarTexto.errorMessage2(), containsString(message)),
                seeThat("El mensaje de error sobre coencidencia de mensaje", ValidarTexto.errorMessageRepite(), containsString(messageRepite))
        );
    }

    //TODO: MI CUENTA
    @Given("^que el usuario ingresa a Mi Cuenta$")
    public void queElUsuarioIngresaAMiCuenta() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Contrasenas.LBL_TITULO, isVisible()).forNoMoreThan(100).seconds()
        );
        theActorInTheSpotlight().attemptsTo(
                IngresarOpcionUsuario.miCuenta()
        );
    }
    @Then("^el muestra el primer nombre del cliente (.*)$")
    public void elMuestraElPrimerNombreDelClientePrimerNombre(String nombre) {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-perfil");
        theActorInTheSpotlight().attemptsTo(EsperarElementoVisible.in(HomeMiCuenta.NOMBRE_USUARIO));
        theActorInTheSpotlight().should(seeThat(ValidarTexto.nombreUsario(), equalTo(nombre)));
    }
    @And("^el muestra la cantidad de millas (.*)$")
    public void elMuestraLaCantidadDeMillasMillas(String millas) {
        theActorInTheSpotlight().should(seeThat(ValidarTexto.millasUsuario(), equalTo(millas)));
    }

    @When("^el selecciona el logo de Interbank Benefit$")
    public void elSeleccionaElLogoDeInterbankBenefit() {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-perfil");
        theActorInTheSpotlight().attemptsTo(
                EsperarElementoVisible.in(HomeMiCuenta.LOGO_INTERBANK));
//        await().forever().pollInterval(2, SECONDS);
//        theActorInTheSpotlight().attemptsTo(
//                MoveMouse.to(LOGO_INTERBANK).andThen(actions -> actions.doubleClick()));
        theActorInTheSpotlight().attemptsTo(JavaScriptClick.on(HomeMiCuenta.LOGO_INTERBANK));
    }
    @When("^el valida que se redirecciona al Home de Benefit$")
    public void validateRedireccion() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Home.MILLAS_HOME3, isVisible()).forNoMoreThan(100).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("Validación de home", ValidacionLogueo.nameHome(), containsString("Vales de canje y giftcards"))
        );
    }
    @When("^el selecciona la opcion de informacion personal$")
    public void elSeleccionaLaOpcionDeInformacionPersonal() {
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().frame("iframe-perfil");
        theActorInTheSpotlight().attemptsTo(
                EsperarElementoVisible.in(HomeMiCuenta.NOMBRE_USUARIO)
        );
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomeMiCuenta.SECCION_INFO_PERSONAL)
        );
    }
    @Then("^el muestra la pantalla de informacion personal$")
    public void elMuestraLaPantallaDeInformacionPersonal() {
        theActorInTheSpotlight().attemptsTo(
                EsperarElementoVisible.in(InformacionPersonal.LABEL_INFORMACION_PERSONAL)
        );
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.tituloInformacionPersonal(), equalTo("Información personal"))
        );
    }
    @And("^el identifica la ruta Cuenta > Informacion personal en la parte superior$")
    public void elIdentificaLaRutaCuentaInformacionPersonalEnLaParteSuperior() {
        theActorInTheSpotlight().should(seeThat(
                ValidarTexto.rutaCuenta(), equalToIgnoringCase("Cuenta"))
                , seeThat(ValidarTexto.rutaInformacion(), equalToIgnoringCase("Información personal")));
    }

    @And("^el identifica su nombre completo del cliente$")
    public void elIdentificaSuNombreCompletoDelCliente() {
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.nombreClienteCompleto(), containsString("Gloria Nila Abarno Roblero"))
        );
    }

    @And("^el muestra su numero de celular ofuscado (.*) y el enlace Actualizar$")
    public void elMuestraSuNumeroDeCelularOfuscadoNumeroYElEnlaceActualizar(String numero) {
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.numeroOfuscado(), containsString(numero)),
                seeThat(ValidarTexto.enlaceActualizarNumero(), equalTo("Registrar"))
        );
    }

    @And("^el muestra el correo electronico ofuscado (.*) y el enlace Actualizar$")
    public void elMuestraElCorreoElectronicoOfuscadoCorreoYElEnlaceActualizar(String correo) {
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.correoOfuscado(), equalTo(correo)),
                seeThat(ValidarTexto.enlaceActualizarCorreo(), equalTo("Actualizar"))
        );
    }

    @And("^el muestra la casilla informativa correo (.*)$")
    public void elMuestraLaCasillaInformativaCorreo(String preguntaInfo) {
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.preguntaInfo(), equalTo(preguntaInfo))
        );
    }
    @Then("^el muestra la pantalla de Inicio de sesion y seguridad$")
    public void elMuestraLaPantallaDeInicioDeSesionYSeguridad() {
        theActorInTheSpotlight().attemptsTo(EsperarElementoVisible.in(InicioSesionYSeguridad.LABEL_INICIO_SESION_SEGURIDAD));


    }

    @And("^el identifica la ruta Cuenta > Inicio de sesion y seguridad$")
    public void elIdentificaLaRutaCuentaInicioDeSesionYSeguridad() {
        theActorInTheSpotlight().should(seeThat(
                ValidarTexto.rutaCuentaSesionYSeguridad(), equalToIgnoringCase("Cuenta"))
                , seeThat(ValidarTexto.rutaInicioSesionYSeguridad(), equalToIgnoringCase("Inicio de sesión y seguridad")));

    }

    @And("^el identifica la informacion (.*) y el enlace Actualizar$")
    public void identificaInformacionUltimaActualizacionHaceXDiasEnlaceActualizar(String ultimaActualizacion) {
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.LabelUltimaActualizacion(), equalTo(ultimaActualizacion)),
                seeThat(ValidarTexto.enlaceActualizarContrasena(), equalTo("Actualizar"))
        );
    }

    @And("^el muestra la casilla informativa sesion y seguridad (.*)$")
    public void elMuestraLaCasillaInformativaSesionYSeguridad(String preguntaInfo) {
        theActorInTheSpotlight().should(seeThat(ValidarTexto.preguntaInfoSesionYSeguridad(), equalTo(preguntaInfo)));
    }

    @And("^el selecciona en la ruta parte Cuenta$")
    public void elSeleccionaEnLaRutaParteCuenta() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(InformacionPersonal.RUTA_CUENTA)
        );
    }

    @Then("^el muestra la pantalla de Mi Cuenta$")
    public void elMuestraLaPantallaDeMiCuenta() {
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.tituloMiCuenta(), equalTo("Mi Cuenta"))
        );
    }

    @And("^el selecciona en enlace Actualizar de Numero de celular$")
    public void elSeleccionaEnEnlaceActualizarDeNumeroDeCelular() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(InformacionPersonal.BTN_ACTUALIZAR_NUM_CEL)
        );
    }
    @Then("^el valida que el enlace cambia de Actualizar a Cancelar$")
    public void elValidaQueElEnlaceCambiaDeActualizarACancelar() {
        theActorInTheSpotlight().should(
                seeThat(ValidarTexto.etiquetaBotonCancelar(), equalTo("Buscar el cajero más cercano"))
        );
    }
}
