package interbank.com.pe.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Yoselyn Cotrina
 */

public class Home {

    public static final Target BUTTON_LOGIN = Target.the("Boton Ingresar").located(By.id("ingresar"));

    //public static final Target WAIT_IFRAME = Target.the("espera Iframe").located(By.id("iframe-login"));
    //public static final Target MILLAS_HOME = Target.the("cantidad millas").locatedBy("//div[contains(@class,'logued')]/div/p[contains(@class,'ng-tns-c0-0')][2]");
    public static final Target MILLAS_HOME2 = Target.the("cantidad millas").locatedBy("//div[1]//p[1]/strong[1]");
    public static final Target MILLAS_HOME3 = Target.the("cantidad millas").locatedBy("//div[@class='title-zone']//h2");
    public static final Target URL_HREF = Target.the("href url").located(By.xpath("//a[@class='item-menu active']"));

    public static final Target BTN_CREAR_CUENTA = Target.the("Crear cuenta").located(By.xpath("//button[@class='registrar']"));
    public static final Target BTN_MUNDO_PRODUCTOS = Target.the("Ingresa al mundo de Productos").located(By.xpath("//*[@id='zona-productos']/div/ibk-button/button"));

    public static final Target BTN_MUMDO_VALES = Target.the("Ingresa al mundo de Vales de consumo").locatedBy("//div[@class='user-zone']/ul/li[4]/a");
    public static final Target BTN_MUNDO_AYUDANOS = Target.the("Ingresa al mundo de Es Tiempo de Ayudar").locatedBy("/html/body/app-root/header/div[3]/div[2]/ul/li[7]/a");//.locatedBy("//div[@class='user-zone']/ul/li[7]/a");
    public static final Target BTN_MUNDO_VIAJES = Target.the("Ingresa al mundo de viajes").locatedBy("//li[@data-menu='viajes']//a");

    public static final Target TXT_BUSCADOR = Target.the("Realizar buscador").located(By.id("searchAll"));

    public static final Target BTN_BUSQUEDA_VALE = Target.the("Selecciona mundo de busqueda").located(By.id("myList"));

    public static final Target BUTTON_USUARIO = Target.the("opcion info cuenta").locatedBy("/html/body/app-root/header/div[4]/div/div[2]/button");
    public static final Target OPTION_MICUENTA = Target.the("opcion mi cuenta").located(By.xpath("/html/body/app-root/header/div[4]/div/div[2]/ul/li/a"));

    public static final Target BTN_CUENTA = Target.the("Desliza Cuenta").locatedBy("//button[@class='drop-button usuario']");
    public static final Target BTN_MIS_CANJES = Target.the("Ver mis canjes").locatedBy("//ul[@class='drop-list']//a[@href='/WebSaas/mis-canjes']");

    public static final Target LBL_MIS_CANJES = Target.the("Mis Canjes").locatedBy("//h1[contains(text(),'Mis canjes')]");
    public static final Target BTN_PRODUCTOS_CANJEADOS = Target.the("Productos canjeados").locatedBy("//li[contains(text(),'Productos')]");

    public static final Target LBL_POR_ENTREGAR = Target.the("Por entregar").locatedBy("//*[@id='mis-canjes-page']/div[1]/div[1]/h2");
    public static final Target LBL_POR_ENTREGAR_GIFTCARDS = Target.the("Por entregar giftcards").locatedBy("//*[@id='mis-canjes-page']/div[1]/div[3]/h2");

}
