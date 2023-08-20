package pages.elements.headerElements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.HomePage;

public class RegionalityPopup extends ActionsWithElements {
    @FindBy(xpath = "//div[@class='popup user-location-popup first-visit popup_active']")
    WebElement regionalityPopup;
    @FindBy(xpath = "//div[@class='popup__title_wrap']//span[@class='city-title']")
    WebElement definedCityTitle;
    @FindBy(xpath = "//span[@class='button user-confirm-location-button']")
    WebElement acceptCity;
    @FindBy(xpath = "//div[@class='popup user-location-popup first-visit popup_active']//div[@class='popup__close']")
    WebElement closePopup;
    @FindBy(xpath = "//span[@class='popup__find-location']")
    WebElement defineCity;
    @FindBy(xpath = "//li[@data-url='lvov']")
    WebElement lvivOption;
    public RegionalityPopup(WebDriver webDriver) {
        super(webDriver);
    }
    public RegionalityPopup defineCity(){
        clickOnElement(defineCity);
        return this;
    }

    public HomePage acceptCity(){
        clickOnElement(acceptCity);
        return new HomePage(webDriver);
    }

    public HomePage closePopup(){
        clickOnElement(closePopup);
        return new HomePage(webDriver);
    }
    public RegionalityPopup checkIfRegionalityPopupIsDisplayed(){
        checkElementDisplayed(regionalityPopup);
        return this;
    }
    public HomePage checkIfRegionalityPopupIsNotDisplayed(){
        checkElementIsNotDisplayed(regionalityPopup);
        return new HomePage(webDriver);
    }
    public HomePage choosingLviv(){
        clickOnElement(lvivOption);
        return new HomePage(webDriver);
    }
    public RegionalityPopup checkIfDefinedCityEqualsKyiv() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertEquals("City", "Київ", definedCityTitle.getText());
        return this;
    }
}
