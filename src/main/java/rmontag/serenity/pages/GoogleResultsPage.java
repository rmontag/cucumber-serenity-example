package rmontag.serenity.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * @author ex532
 * Page Objects hide the WebDriver implementation details about how elements on a page are accessed and manipulated behind simple methods.
 *
 */
public class GoogleResultsPage extends PageObject {

	@FindBy(xpath = "//h3/a")
	private List<WebElement> linkTitlesList;

	@WhenPageOpens
	public void waitForPage() {
		// wait for google sub menu: Web | Images | Videos | ...
		$("#hdtb-msb").waitUntilVisible();
	}

	public List<String> getResultsList() {
		List<String> resultsList = new ArrayList<>();
		for (WebElement element : linkTitlesList) {
			resultsList.add(element.getText());
		}
		return resultsList;
	}

}
