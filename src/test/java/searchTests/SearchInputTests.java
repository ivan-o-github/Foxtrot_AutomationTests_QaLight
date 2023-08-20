package searchTests;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.*;

public class SearchInputTests extends BaseTest {
    @Test
    public void clearSearchInput() {
        pageProvider.getHomePage()
                .openHomePageAndCloseRegionalityPopup()
                .getHeader()
                .getSearchElement()
                .enterTextIntoSearchInput(IPHONE_14_QUERY)
                .checkIfSearchQueryIsDisplayedInSearchInput(IPHONE_14_QUERY)
                .clearSearchInput()
                .checkIfSearchInputIsClear();
    }

    @Test
    public void searchForIphone14() {
        pageProvider.getHomePage()
                .openHomePageAndCloseRegionalityPopup()
                .getHeader()
                .getSearchElement()
                .enterTextIntoSearchInput(IPHONE_14_QUERY)
                .checkIfSearchQueryIsDisplayedInSearchInput(IPHONE_14_QUERY)
                .acceptSearchQuery()
                .checkIfPageIsSearchResultPage("iPhone%2014")
                .getSearchResultPage()
                .checkIfSearchResultPageEqualsSearchQuery(IPHONE_14_QUERY)
                .checkIfSearchResultsAreIphone();
    }

    @Test
    public void searchForCategory() {
        pageProvider.getHomePage()
                .openHomePageAndCloseRegionalityPopup()
                .getHeader()
                .getSearchElement()
                .enterTextIntoSearchInput(CATEGORY_QUERY)
                .checkIfSearchQueryIsDisplayedInSearchInput(CATEGORY_QUERY)
                .acceptSearchQuery()
                .checkIfPageIsSearchResultPage(CATEGORY_QUERY)
                .getSearchResultPage()
                .checkIfSearchResultPageEqualsSearchQuery(CATEGORY_QUERY)
        ;
    }
}
