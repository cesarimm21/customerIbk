package interbank.com.pe.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Yoselyn Cotrina
 */

public class Login {

    public static final Target BTN_INICIA_SESION = Target.the("Inicia sesión").located(By.xpath("//button[@class='iniciar-sesion']"));

    // --- > Elementos del antiguo Login
    public static final Target LBL_USER = Target.the("Ingresa su usuario").located(By.id("username"));
    public static final Target LBL_PASS = Target.the("Ingresa password").located(By.id("password"));
    public static final Target BTN_INGRESAR_ANTIGUO = Target.the("Inicia sesión").located(By.id("btnlogin"));
    //--- Fin
    public static final Target BTN_INGRESAR = Target.the("boton ingresar").located(By.xpath("/html/body/app-root/app-login/form/div[1]/mat-card/mat-card-actions/app-bnf-button/div/div[1]/button"));
    public static final Target LBL_TITULO = Target.the("Iniciar Sesión").located(By.cssSelector(".mat-card-title-bft"));
    public static final Target CBX_TIPO_DOC_DNI = Target.the("DNI").locatedBy("/html/body/app-root/app-login/form/div[1]/mat-card/mat-card-content/app-document-tool/div[1]/mat-form-field/div/div[1]");
    public static final Target TXT_NUM_DOC = Target.the("Numero de documento").located(By.id("mat-input-1"));
    public static final Target TXT_CONTRASENA = Target.the("contraseña").located(By.id("mat-input-0"));
    public static final Target OLVIDE_CONTRASENA = Target.the("El ingresa al enlace olvide mi contrasena").locatedBy("//label[contains(@class,'text-link') and text()=' ¿Olvidaste tu contraseña? ']");

    // --- > Elementos del nuevo login
    public static final Target SELECT_TYPE_DOCUMENT_LOGIN = Target.the("opcion de tipo documento").located(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/label"));
    public static final Target TYPE_DOCUMENT_LOGIN = Target.the("desplegar tipo documento").located(By.id("mat-select-0"));
    public static final Target NUMBER_DOCUMENT_LOGIN = Target.the("Número de documento").located(By.id("mat-input-1"));
    public static final Target PASSWORD_LOGIN = Target.the("Contraseña").located(By.id("mat-input-0"));
    public static final Target BTN_INGRESAR_LOGIN = Target.the("boton ingresar").located(By.xpath("//mat-card/mat-card-actions/app-bnf-button//div[1]/button"));

    public static final Target INP_VALUE = Target.the("campo numero documento").located(By.xpath("//input[contains(@class,'mat-input-element')]"));

    public static final Target OPEN_OPTIONS = Target.the("Desplega el combobock").located(By.xpath("//mat-form-field[@appearance='outline']"));//div[@class='mat-form-field-outline ng-tns-c4-4 ng-star-inserted']
    public static final Target LBL_SELECT = Target.the("campo numero documento").locatedBy("//label[text()='{0}']");

    public static final Target LINK_CREAR_CUENTA = Target.the("enlace crear cuenta").locatedBy("//div/label/label");
    public static final Target LINK_RETROCEDER = Target.the("enlace retroceder").located(By.xpath("/html/body/app-root/app-login/form/div[1]/mat-card/mat-card-footer/div[1]/label"));
    public static final Target BTN_GET_INTO_LOGIN = Target.the("boton ingresar").located(By.xpath("/html/body/app-root/app-login/form/div[1]/mat-card/mat-card-actions/app-bnf-button/div/div[1]/button"));

    //--> Error label login
    public static final Target LABEL_ERROR_DOCUMENTO = Target.the("mensaje error documento").located(By.xpath("/html/body/app-root/app-login/form/div[1]/mat-card/mat-card-content/app-document-tool/div[2]/mat-form-field/div/div[2]/div/mat-error"));
    public static final Target LABEL_ERROR_PASSWORD = Target.the("mensaje error password").located(By.xpath("/html/body/app-root/app-login/form/div[1]/mat-card/mat-card-content/div/mat-form-field/div/div[2]/div/mat-error"));

    //--> Error Back login
    public static final Target LABEL_ERROR_BACK = Target.the("error back").located(By.xpath("//div[contains(@class,'message-error')]"));

}
