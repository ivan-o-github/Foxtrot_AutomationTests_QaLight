package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.HomePage;
import pages.elements.headerElements.RegionalityPopup;
import pages.elements.headerElements.Search;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//p[@class='city-title']")
    public WebElement regionalCityTitle;
    public Header(WebDriver webDriver) {
        super(webDriver);
    }
    public Search getSearchElement(){
        return new Search(webDriver);
    }
    public RegionalityPopup getRegionalityPopup(){
        return new RegionalityPopup(webDriver);
    }
    public HomePage checkIfCityFromHeaderIsMatchingChosenCity(String city){
        Assert.assertEquals("City", city, regionalCityTitle.getText());
        return new HomePage(webDriver);
    }
    public HomePage checkIfCityFromHeaderIsDefault() {
        Assert.assertEquals("City", "Київ", regionalCityTitle.getText());
        return new HomePage(webDriver);
    }
    public RegionalityPopup callRegionalityPopupByClickingCityTitleInHeader(){
        clickOnElement(regionalCityTitle);
        return new RegionalityPopup(webDriver);
    }
}
