package interbank.com.pe.questions.myaccount;

import interbank.com.pe.userinterfaces.myaccount.HomeMiCuenta;
import interbank.com.pe.userinterfaces.myaccount.InformacionPersonal;
import interbank.com.pe.userinterfaces.myaccount.InicioSesionYSeguridad;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class ValidarTexto {

    public static Question<String> nombreUsario() {
        return actor -> HomeMiCuenta.NOMBRE_USUARIO.resolveFor(actor).getText();
    }

    public static Question<String> millasUsuario() {
        return actor -> HomeMiCuenta.NUMERO_MILLAS.resolveFor(actor).getText();
    }

    public static Question<String> tituloInformacionPersonal() {
        return actor -> InformacionPersonal.LABEL_INFORMACION_PERSONAL.resolveFor(actor).getText();
    }

    public static Question<String> rutaCuenta() {
        return actor -> InformacionPersonal.RUTA_CUENTA.resolveFor(actor).getText();
    }

    public static Question<String> rutaInformacion() {
        return actor -> InformacionPersonal.RUTA_INFORMACION_PERSONAL.resolveFor(actor).getText();
    }

    public static Question<String> nombreClienteCompleto() {
        return actor -> InformacionPersonal.NOMBRE_COMPLETO_USUARIO.resolveFor(actor).getText();
    }

    public static Question<String> numeroOfuscado() {
        return actor -> InformacionPersonal.NUMERO_OFUSCADO_USUARIO.resolveFor(actor).getText();
    }

    public static Question<String> enlaceActualizarNumero() {
        return actor -> InformacionPersonal.ENLACE_ACTUALIZAR_NUMERO.resolveFor(actor).getText();
    }

    public static Question<String> correoOfuscado() {
        return actor -> InformacionPersonal.CORREO_OFUSCADO_USUARIO.resolveFor(actor).getText();
    }

    public static Question<String> enlaceActualizarCorreo() {
        return actor -> InformacionPersonal.ENLACE_ACTUALIZAR_CORREO.resolveFor(actor).getText();
    }

    public static Question<String> preguntaInfo() {
        return actor -> InformacionPersonal.PREGUNTA_INFORMATIVA.resolveFor(actor).getText();
    }

    public static Question<String> rutaCuentaSesionYSeguridad() {
        return actor -> InicioSesionYSeguridad.PATH_CUENTA_INICIAR_SESION.resolveFor(actor).getText();
    }

    public static Question<String> rutaInicioSesionYSeguridad() {
        return actor -> InicioSesionYSeguridad.PATH_INICIAR_SESION_SEGURIDAD.resolveFor(actor).getText();
    }

    public static Question<String> LabelUltimaActualizacion() {
        return actor -> InicioSesionYSeguridad.LABEL_ULTIMA_ACTUALIZACION.resolveFor(actor).getText();
    }

    public static Question<String> enlaceActualizarContrasena() {
        return actor -> InicioSesionYSeguridad.ENLACE_ACTUALIZAR_CONTRASENA.resolveFor(actor).getText();
    }

    public static Question<String> preguntaInfoSesionYSeguridad() {
        return actor -> InicioSesionYSeguridad.CASILLA_INFO_SESION_SEGURIDAD.resolveFor(actor).getText();
    }

    public static Question<String> tituloMiCuenta() {
        return actor -> HomeMiCuenta.LBL_MI_CUENTA.resolveFor(actor).getText();
    }

    public static Question<String> etiquetaBotonCancelar() {
        return actor -> InformacionPersonal.BTN_ACTUALIZAR_NUM_CEL.resolveFor(actor).getText();
    }

    public static Question<String> etiquetaBotonActualizar() {
        return actor -> InformacionPersonal.BTN_ACTUALIZAR_NUM_CEL.resolveFor(actor).getText();
    }

    public static Question<String> tituloModalCambioNumero() {
        return actor -> InformacionPersonal.LBL_TITULO_CAMBIO_NUM.resolveFor(actor).getText();
    }

    public static Question<String> botonVolverEnviar() {
        return actor -> InformacionPersonal.BTN_VOLVER_ENVIAR.resolveFor(actor).getText();
    }

    public static Question<String> textTittle() {
        return actor -> TextContent.of(HomeMiCuenta.LBL_INICIO).viewedBy(actor).asString();
    }

    public static Question<String> textTittleLast() {
        return actor -> TextContent.of(HomeMiCuenta.LBL_TITLE_SUB).viewedBy(actor).asString();
    }

    public static Question<String> textTittleBuzon() {
        return actor -> TextContent.of(HomeMiCuenta.LBL_TITLE_SUB2).viewedBy(actor).asString();
    }

    public static Question<String> textSuccess() {
        return actor -> TextContent.of(HomeMiCuenta.BTN_SUCCESS).viewedBy(actor).asString();
    }

    public static Question<String> errorMessage() {
        return actor -> TextContent.of(HomeMiCuenta.SPN_MESSAGE_ERROR).viewedBy(actor).asString();
    }

    public static Question<String> errorMessage2() {
        return actor -> TextContent.of(HomeMiCuenta.SPN_MESSAGE_ERROR2).viewedBy(actor).asString();
    }

    public static Question<String> errorMessageRepite() {
        return actor -> TextContent.of(HomeMiCuenta.SPN_MESSAGE_ERROR_NO).viewedBy(actor).asString();
    }
}
