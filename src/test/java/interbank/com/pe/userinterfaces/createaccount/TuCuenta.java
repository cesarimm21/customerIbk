package interbank.com.pe.userinterfaces.createaccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Yoselyn Cotrina
 */

public class TuCuenta {

    public static Target LBL_TITULO = Target.the("Titulo").locatedBy("//mat-card-header//mat-card-title[4]");
    public static Target BTN_INICIASESION = Target.the("Iniciar sesion").locatedBy("/html/body/app-root/app-register/app-register-one-step/form/div[2]/div/div/label/label");

    public static Target CBX_SELECCIONA_TIP_DOC = Target.the("Selecciona Tipo de Documento").located(By.id("mat-select-0"));
    public static Target CBX_TIPO_DOC_SELECIONA = Target.the("DNI").located(By.id("mat-option-0"));
    public static Target CBX_TIPO_DOC_DNI = Target.the("DNI").located(By.id("mat-option-1"));
    public static Target CBX_TIPO_DOC_CE = Target.the("Carné de extranjeria").located(By.id("mat-option-2"));
    public static Target CBX_TIPO_DOC_PASS = Target.the("Pasaporte").located(By.id("mat-option-3"));
    public static Target TXT_NUM_DOC = Target.the("Numero de documento").located(By.id("mat-input-0"));
    public static Target BTN_CONTINUAR = Target.the("Botón continuar al Paso 2").locatedBy("//app-bnf-button/div/div[1]/button");

    public static Target LBL_TIPO_ERROR = Target.the("Mensaje de Validacion del Tipo de Documento").located(By.id("mat-error-1"));
    public static Target LBL_NUM_DOC_ERROR = Target.the("Mensaje de Validacion del Número de Documento").located(By.id("mat-error-0"));

}
