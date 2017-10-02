package rmontag.serenity.features.steps.serenity;

import java.util.List;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import rmontag.serenity.pages.GoogleResultsPage;
import rmontag.serenity.pages.GoogleSearchPage;

/**
 * @author ex532
 * Step library, steps are annotated with @Step
 * The step library methods do not call Selenium Web Driver directly, but rather interact with Page Objects
 *
 */
public class GoogleSearchSteps {
	
	private GoogleSearchPage searchPage;
	private GoogleResultsPage resultsPage;

	@Step
	public void openGoogleSearchPage() {
		searchPage.open();
	}

	@Step
	public void searchFor(String searchRequest) {
		// HOW does Serenity knows when to instantiate the results page ???
//		resultsPage = searchPage.searchFor(searchRequest);
		searchPage.searchFor(searchRequest);
	}

	@Step
	public void verifyResult(String searchResult) {
		List<String> results = resultsPage.getResultsList();
		Assert.assertTrue(results.contains(searchResult));
	}

}
