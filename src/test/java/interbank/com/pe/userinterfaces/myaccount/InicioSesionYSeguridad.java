package interbank.com.pe.userinterfaces.myaccount;

import net.serenitybdd.screenplay.targets.Target;

public class InicioSesionYSeguridad {

    public static final Target LABEL_INICIO_SESION_SEGURIDAD = Target.the("texto inicio de sesion y seguridad").locatedBy("/html/body/app-root/app-profile/app-profile-login-security/form/mat-card/mat-card-header/div/mat-card-title");
    public static final Target PATH_CUENTA_INICIAR_SESION = Target.the("ruta cuenta").locatedBy("/html/body/app-root/app-profile/app-profile-login-security/form/mat-card/mat-card-header/div/mat-card-subtitle/span[1]");
    public static final Target PATH_INICIAR_SESION_SEGURIDAD = Target.the("ruta iniciar sesion").locatedBy("/html/body/app-root/app-profile/app-profile-login-security/form/mat-card/mat-card-header/div/mat-card-subtitle/span[3]");
    public static final Target LABEL_ULTIMA_ACTUALIZACION = Target.the("ultima actualizacion").locatedBy("/html/body/app-root/app-profile/app-profile-login-security/form/mat-card/mat-card-content/div[1]/div/div/label");
    public static final Target ENLACE_ACTUALIZAR_CONTRASENA = Target.the("enlace actualizar").locatedBy("/html/body/app-root/app-profile/app-profile-login-security/form/mat-card/mat-card-content/div[1]/div/div/div/div/label");
    public static final Target CASILLA_INFO_SESION_SEGURIDAD = Target.the("casilla informacion").locatedBy("/html/body/app-root/app-profile/app-profile-login-security/form/mat-card/mat-card-content/div[2]/div/div/label[1]");

}
