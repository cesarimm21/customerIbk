package interbank.com.pe.userinterfaces.headers;

import net.serenitybdd.screenplay.targets.Target;

public class HeadersPage {

    public static final Target SPN_CINTILLO = Target.the("Mensaje de cintillo").locatedBy("//div[@class='cintillo']//span");
    public static final Target SPN_MILLAS = Target.the("Mensaje de millas").locatedBy("//div[@class='account-log']//p");

    //Mi cuenta
    public static final Target BTN_DROP_LOGIN = Target.the("Desplegar cuenta").locatedBy("//button[@class='drop-login-button']");
    public static final Target A_CUENTA = Target.the("Opción cuenta").locatedBy("//a[@href='https://saaspp.com/WebSaas/micuenta']");
}
