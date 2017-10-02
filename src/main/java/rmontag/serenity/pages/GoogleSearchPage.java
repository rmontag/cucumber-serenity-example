package rmontag.serenity.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * @author ex532
 * Page Objects hide the WebDriver implementation details about how elements on a page are accessed and manipulated behind simple methods.
 * 
 * WebDriver method open() opens page according to @DefaultUrl annotation.
 * If @DefaultUrl is missing - WebDriver will open webdriver.base.url from property file 'serenity.properties'.
 * 
 * You can use the $ method to access elements directly using CSS, id or XPath expressions.
 * Or, you may use a member variable annotated with the @FindBy.
 * 
 * open() is inherited from PageObject class.
 *
 */
@DefaultUrl("https://google.com")
public class GoogleSearchPage extends PageObject {

	@FindBy(id = "lst-ib")
	private WebElement searchInputField;

	@WhenPageOpens
	public void waitUntilGoogleLogoAppears() {
		$("#hplogo").waitUntilVisible();
	}

	public GoogleResultsPage searchFor(String searchRequest) {
		element(searchInputField).clear();
	    element(searchInputField).typeAndEnter(searchRequest);
//	    return new GoogleResultsPage(getDriver());
	    return new GoogleResultsPage();
	}

}
