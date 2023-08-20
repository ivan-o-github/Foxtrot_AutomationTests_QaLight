package pages.elements.headerElements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.SearchResultsPage;
import pages.elements.Header;

public class Search extends Header {
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchInput;
    @FindBy(xpath = "//input[@class='header-search__button evinent-search-button']")
    WebElement acceptSearchButton;
    @FindBy(id = "searchClear")
    WebElement clearSearchInput;
    @FindBy(xpath = "//span[@class='evinent-search-category-title']//span")
    WebElement top5Suggestions;
    @FindBy(xpath = "//div[@class='evinent-active']")
    WebElement searchMenu;
    public Search(WebDriver webDriver) {
        super(webDriver);
    }
    public Search enterTextIntoSearchInput(String searchQuery){
        clickOnElement(searchInput);
        enterTextIntoInput(searchInput, searchQuery);
        return this;
    }
    public SearchResultsPage acceptSearchQuery(){
        clickOnElement(acceptSearchButton);
        return new SearchResultsPage(webDriver);
    }

    public Search clearSearchInput(){
        clickOnElement(clearSearchInput);
        return this;
    }

    public Search checkIfSearchQueryIsDisplayedInSearchInput(String searchQuery){
        checkElementDisplayed(searchMenu);
        checkElementDisplayed(top5Suggestions);
        Assert.assertEquals("", top5Suggestions.getText(), searchQuery.toLowerCase());
        return this;
    }

    public Search checkIfSearchInputIsClear(){
        checkElementIsNotDisplayed(searchMenu);
        return this;
    }
}
