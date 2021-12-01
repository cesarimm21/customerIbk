package interbank.com.pe.questions;

import interbank.com.pe.userinterfaces.Home;
import net.serenitybdd.screenplay.Question;

public class ValidacionUrl {

    public static Question<String> url() {
        return actor -> Home.URL_HREF.resolveFor(actor).waitUntilVisible().getAttribute("href");
    }
}
