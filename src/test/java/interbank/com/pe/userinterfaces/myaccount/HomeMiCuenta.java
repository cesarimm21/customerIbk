package interbank.com.pe.userinterfaces.myaccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeMiCuenta {

    public static final Target NOMBRE_USUARIO = Target.the("nombre de usuario").located(By.xpath("/html/body/app-root/app-profile/app-profile-main/form/app-profile-header/div/div/label[1]"));
    public static final Target NUMERO_MILLAS = Target.the("cantidad de millas").located(By.xpath("/html/body/app-root/app-profile/app-profile-main/form/app-profile-header/div/div/label[2]/strong"));
    public static final Target LOGO_INTERBANK = Target.the("logo interbank").locatedBy("/html/body/app-root/app-profile/app-profile-main/form/app-profile-header/div/img");
    public static final Target SECCION_INFO_PERSONAL = Target.the("informacion personal").locatedBy("/html/body/app-root/app-profile/app-profile-main/form/mat-card/mat-card-content/div/app-profile-menu[1]/div");
    public static final Target SECCION_SESION_Y_SEGURIDAD = Target.the("sesion y seguridad").locatedBy("/html/body/app-root/app-profile/app-profile-main/form/mat-card/mat-card-content/div/app-profile-menu[2]/div");

    public static final Target LBL_MI_CUENTA = Target.the("Titulo Mi cuenta").locatedBy("/html/body/app-root/app-profile/app-profile-main/form/mat-card/mat-card-header/div/mat-card-title");
    //ACTUALIZAR CONTRASEÑA MI CUENTA
    public static final Target LBL_INICIO = Target.the(" Inicio de sesión y seguridad ").locatedBy("//mat-card-title[@class='mat-card-header-profile-title mat-card-title']");
    public static final Target BTN_ACTUALIZAR = Target.the(" Botón actualizar ").locatedBy(".text-label-link > div");
    public static final Target INP_PASSWORD_01 = Target.the("Ingresa una contraseña para continuar.").locatedBy("(//input[@type='password'])[1]");
    public static final Target INP_PASSWORD_02 = Target.the("Ingresa una contraseña para continuar. Las contraseñas deben coincidir.").locatedBy("(//input[@type='password'])[2]");
    public static final Target BTN_SAVE = Target.the(" Botón  Guardar  ").locatedBy("//button[@class='mat-button mat-button-base mat-button-bnf']");
    public static final Target INP_CODIGO = Target.the("Ingresamos Codigo ").locatedBy("//input[@formcontrolname='activationCodeCtrl']");
    //ACTUALIZAR CONTRASEÑA DE OLVIDE CONTRASEÑA
    public static final Target LBL_TITLE2 = Target.the(" Revisa tu correo ").locatedBy("//mat-card-title[@class='mat-card-title-bft mat-card-title']");

    //public static final Target BTN_VOLVERENVIAR = Target.the(" Volver a enviar ").locatedBy("(//label[@class='activation-code-resend'])[2]");
    public static final Target BTN_FORGOT = Target.the(" ¿Olvidaste tu contraseña? ").locatedBy("(//label[@class='text-link'])[2]");
    
    public static final Target LBL_TITLE_SUB = Target.the(" Ingresa el código para guardar el cambio ").locatedBy("//mat-card-title[@class='mat-card-title-bft-dialog mat-card-title-bf-dialog mat-card-title']");
    public static final Target BTN_SAVE_PASSWORD = Target.the(" Guardar nueva contraseña ").locatedBy("(//button[@class='mat-button mat-button-base mat-button-bnf'])[2]");
    public static final Target BTN_SUCCESS = Target.the(" Mensaje de exito ").locatedBy("//div[@class='message-successful']");

    public static final Target BTN_CONTINUAR = Target.the(" Botón continuar ").locatedBy("//button[@class='mat-button mat-button-base mat-button-bnf']");
    public static final Target LBL_TITLE_SUB2 = Target.the(" Revisa tu correo ").locatedBy("//mat-card-title[@class='mat-card-title-bft mat-card-title']");
    public static final Target BTN_SAVE_PASSWORD2 = Target.the(" Guardar nueva contraseña ").locatedBy("(//button[@class='mat-button mat-button-base mat-button-bnf'])[1]");

    public static final Target SPN_MESSAGE_ERROR = Target.the(" Mensaje de error").locatedBy("//mat-error[@class='mat-error ng-star-inserted']");
    public static final Target SPN_MESSAGE_ERROR2 = Target.the(" Mensaje de error").locatedBy("(//mat-error[@class='mat-error ng-star-inserted'])[2]");
    public static final Target SPN_MESSAGE_ERROR_NO = Target.the(" Las contraseñas deben coincidir").locatedBy("(//mat-error[@class='mat-error ng-star-inserted'])[3]");
}
