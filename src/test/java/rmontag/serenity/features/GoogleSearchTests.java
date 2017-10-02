package rmontag.serenity.features;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;

/**
 * File should be in package that we specified in failsafe maven plugin.
 * 
 * A Scenario runner.
 * @author rmontag
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features")
public class GoogleSearchTests {
	
//	@Managed(driver = "firefox")
//	WebDriver browser;

}
