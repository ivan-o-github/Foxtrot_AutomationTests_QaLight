package pages;

import data.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.TestData.*;

public class SearchResultsPage extends ParentPageWithHeaderAndFooter {
    @FindBy(xpath = "//div[@class='page__title']//h1")
    WebElement searchedTitle;
    @FindBy(xpath = "//div[@class='card__body']//a[contains(text(),'iPhone 14')]")
    WebElement miniPdpIphone;

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PageProvider checkIfPageIsSearchResultPage(String searchQuery) {
        TestData.setCategories();
        if (categories.containsKey(searchQuery)) {
            Assert.assertEquals("Url is not expected \n" +
                            "Expected result: " + BASE_URL + "/shop/" + categories.get(searchQuery) + ".html" + "\n" +
                            "Actual result: " + webDriver.getCurrentUrl()
                    , webDriver.getCurrentUrl(), BASE_URL + "/shop/" + categories.get(searchQuery) + ".html");
        } else {
            Assert.assertEquals("Url is not expected \n" +
                            "Expected result: " + BASE_URL + "/search?query=" + searchQuery + "\n" +
                            "Actual result: " + webDriver.getCurrentUrl()
                    , webDriver.getCurrentUrl(), BASE_URL + "/search?query=" + searchQuery);
        }
        return new PageProvider(webDriver);
    }

    public SearchResultsPage checkIfSearchResultPageEqualsSearchQuery(String searchQuery) {
        if (categories.containsKey(searchQuery)) {
            Assert.assertEquals("", searchedTitle.getText(), searchQuery);
        } else {
            Assert.assertEquals("", searchedTitle.getText(), "Знайдено по запиту «" + searchQuery + "»");
        }
        return new SearchResultsPage(webDriver);
    }

        public SearchResultsPage checkIfSearchResultsAreIphone () {
            checkElementDisplayed(miniPdpIphone);
            return new SearchResultsPage(webDriver);
        }

    }
