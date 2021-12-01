package interbank.com.pe.userinterfaces.createaccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Yoselyn Cotrina
 */

public class Contrasenas {

    public static final Target LBL_TITULO = Target.the("Titulo").locatedBy("/html/body/app-root/app-register/app-register-two-step/form/div[2]/mat-card/mat-card-header/div/mat-card-title[4]");//("/html/body/app-root/app-register/app-register-three-step/form/div[2]/mat-card/mat-card-header/div/mat-card-title[4]");
    public static final Target LBL_TITULO_POPUP = Target.the("Titulo").locatedBy("//*[@class='dialog-content']//p");//("/html/body/app-root/app-register/app-register-three-step/form/div[2]/mat-card/mat-card-header/div/mat-card-title[4]");
    public static final Target TXT_CONTRASENA = Target.the("Contraseña").locatedBy("//*[@id='mat-input-1']");
    public static final Target TXT_RECONTRASENA = Target.the("Re Contraseña").locatedBy("//*[@id='mat-input-2']");
    public static final Target CHX_TERMINOS_CONDICIONES = Target.the("Uso de mis datos personales").locatedBy("//*[@id='mat-checkbox-1']/label/div");
    public static final Target CHX_POLITICAS_PRIVACIDAD = Target.the("Terminos y condiciones").locatedBy("//*[@id='mat-checkbox-2']/label/div");

    public static final Target LNK_DATOS_PERSONALES = Target.the("Link datos personales").locatedBy("/html/body/app-root/app-register/app-register-two-step/form/div[2]/mat-card/mat-card-content/div[1]/label");
    public static final Target LNK_TERMINOS_CONDICIONES = Target.the("Link Terminos y condiciones").locatedBy("//label[@class='mat-checkbox-bnf-link']");
    public static final Target BTN_ENTENDIDO = Target.the("Botón Entendido").locatedBy("//*[@class='dialog-content']//button");
    public static final Target BTN_RETROCEDER = Target.the("Botón Retroceder").locatedBy("");

    public static final Target BTN_CONTINUAR = Target.the("Botón Continuar").locatedBy("/html/body/app-root/app-register/app-register-two-step/form/div[2]/mat-card/mat-card-actions/app-bnf-button/div/div[1]/button");
    public static final Target LBL_CONTRASENA_ERROR = Target.the("Error de contraseña").locatedBy("/html/body/app-root/app-register/app-register-two-step/form/div[2]/mat-card/mat-card-content/app-password-tool/div[1]/mat-form-field/div/div[2]/div");

    public static final Target LBL_RECONTRASENA_ERROR = Target.the("Error de repetir contraseña").locatedBy("/html/body/app-root/app-register/app-register-two-step/form/div[2]/mat-card/mat-card-content/app-password-tool/div[2]/mat-form-field/div/div[2]/div");

}

