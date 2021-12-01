package interbank.com.pe.userinterfaces.createaccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Yoselyn Cotrina
 */

public class RevisaTuCorreo {

    public static Target LBL_TITULO = Target.the("Titulo").locatedBy("/html/body/app-root/app-register/app-register-three-step/form/div[2]/mat-card/mat-card-header/div/mat-card-title[4]");
    public static Target TXT_CODIGO = Target.the("Código Otp").located(By.id("mat-input-3"));
    public static Target LBL_CODIGO_ERROR = Target.the("Mensaje de error").located(By.id("mat-error-8"));
    public static Target LNK_CAMBIO_CORREO = Target.the("link ¿Has cambiado de correo?").locatedBy("/html/body/app-root/app-register/app-register-three-step/form/div[2]/mat-card/mat-card-header/div/mat-card-subtitle/label");
    public static Target TBL_ACTUALIZA_CORREO = Target.the("titulo actualiza tu correo").locatedBy("//*[@id='update-mail-dialog']/app-dialog-update-mail/div/div[2]/p");
    public static Target BTN_CERRAR = Target.the("Cerrar ventana (x)").locatedBy("//*[@id='update-mail-dialog']/app-dialog-update-mail/div/div[1]/span");
    public static Target LNK_VOLVER_ENVIAR = Target.the("link Volver a enviar").locatedBy("/html/body/app-root/app-register/app-register-three-step/form/div[2]/mat-card/mat-card-content/app-bnf-link/div/label");
    public static Target LBL_EXITOSO_REENVIO_CODIGO = Target.the("Mensaje exitoso Reenvio de codigo").locatedBy("/html/body/app-root/app-register/app-register-three-step/form/div[2]/mat-card/mat-card-header/div/mat-card-title[2]/div");
    public static Target BTN_RETROCEDER = Target.the("Botón Retroceder").locatedBy("/html/body/app-root/app-register/app-register-three-step/form/div[2]/mat-card/mat-card-footer/div/label");
    public static Target BTN_CREAR_CUENTA = Target.the("Botón Crear Cuenta").locatedBy("//app-bnf-button/div/div[1]/button");

}
