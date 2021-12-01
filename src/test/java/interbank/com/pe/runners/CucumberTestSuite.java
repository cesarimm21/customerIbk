package interbank.com.pe.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue ={"interbank.com.pe.stepsdefinitions"},
        tags = {"@Automated","@CHANGE_PASSWORD1"}
)
public class CucumberTestSuite {
    @Managed(uniqueSession = true, clearCookies = BeforeEachTest)
    WebDriver driver;
}
