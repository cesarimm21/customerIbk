package interbank.com.pe.userinterfaces.myaccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Yoselyn Cotrina
 */

public class InformacionPersonal {

    public static final Target LABEL_INFORMACION_PERSONAL = Target.the("label info personal").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-header/div/mat-card-title");
    public static final Target RUTA_CUENTA = Target.the("ruta cuenta").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-header/div/mat-card-subtitle/span[1]");
    public static final Target RUTA_INFORMACION_PERSONAL = Target.the("ruta informacion personal").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-header/div/mat-card-subtitle/span[3]");
    public static final Target NOMBRE_COMPLETO_USUARIO = Target.the("nombre completo").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-content/div[1]/div[1]/label[2]");
    public static final Target NUMERO_OFUSCADO_USUARIO = Target.the("numero ofuscado").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-content/div[1]/div[3]/div/div/label[2]");
    public static final Target ENLACE_ACTUALIZAR_NUMERO = Target.the("enlace actualizar").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-content/div[1]/div[3]/div/div/div/div/label");
    public static final Target CORREO_OFUSCADO_USUARIO = Target.the("correo ofuscado").located(By.className("text-value-email"));
    public static final Target ENLACE_ACTUALIZAR_CORREO = Target.the("enlace actualizar").locatedBy("//label[@class='link-green']");
    public static final Target PREGUNTA_INFORMATIVA = Target.the("pregunta informativa").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-content/div[2]/div/div/label[1]");

    public static final Target BTN_ACTUALIZAR_NUM_CEL = Target.the("Actualizar el numero de celular").located(By.className("link-green ng-star-inserted"));
    public static final Target CBX_OPERADOR = Target.the("Conbobox del Operador").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-content/div[1]/div[3]/div[2]/app-cellphone-tool/div[1]/mat-form-field/div/div[1]/div[3]");
    public static final Target CBX_SELECCIONAR_OPER = Target.the("Seleccionar Operador").locatedBy("//*[@id='mat-option-'{0}'']");

    public static final Target TXT_NUMERO_CELULAR = Target.the("Número de celular").locatedBy("//*[@id='selectedCellPhoneNumber']");//"/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-content/div[1]/div[3]/div[2]/app-cellphone-tool/div[2]/mat-form-field/div/div[1]/div[3]");
    public static final Target BTN_GUARDAR = Target.the("Guardar cambio de numero de celular").locatedBy("/html/body/app-root/app-profile/app-profile-personal-information/form/mat-card/mat-card-content/div[1]/div[3]/div[2]/app-bnf-button/div/div[1]/button");
    public static final Target LBL_ERROR_INCOMPLETO = Target.the("Mensaje de error numero incompleto").locatedBy("//*[@id='mat-error-1']");
    public static final Target LBL_ERROR_VACIO = Target.the("Mensaje de error campo numero de celular vacio").locatedBy("//*[@id='mat-error-0']");

    public static final Target LBL_TITULO_CAMBIO_NUM = Target.the("Titulo del modal cambio de número").locatedBy("/html/body/div[1]/div[2]/div/mat-dialog-container/app-dialog-validatecode/form/mat-card/mat-card-header/div/mat-card-title[3]");
    public static final Target LBL_CORREO_MODAL = Target.the("Correo Ofuscado").locatedBy("html/body/div[1]/div[2]/div/mat-dialog-container/app-dialog-validatecode/form/mat-card/mat-card-header/div/mat-card-title[4]/label/strong");
    public static final Target BTN_VOLVER_ENVIAR = Target.the("Enlace volver a eviar").locatedBy("/html/body/div[1]/div[2]/div/mat-dialog-container/app-dialog-validatecode/form/mat-card/mat-card-content/div[2]/label");
    public static final Target BTN_GUARDAR_NUEVO_NUM = Target.the("Botón guardar nuevo número").locatedBy("/html/body/div[1]/div[2]/div/mat-dialog-container/app-dialog-validatecode/form/mat-card/mat-card-actions/div/app-bnf-button/div/div[1]/button/span");
    public static final Target BTN_CANCELAR = Target.the("Botón Cancelar").locatedBy("/html/body/div[1]/div[2]/div/mat-dialog-container/app-dialog-validatecode/form/mat-card/mat-card-actions/div/div/button/span");
    //public static final Target TXT_CODIGO = Target.the("Ingresar Codigo de verificación").locatedBy("//*[@id='mat-input-1']");
    //public static final Target LBL_ERROR_CODIGO = Target.the("Mensaje de Error").locatedBy("//*[@id='mat-error-1']");

}
