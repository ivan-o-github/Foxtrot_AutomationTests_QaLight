package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait_10, webDriverWait_15;


    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait_10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait_15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
        }
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input " + getElementName(input));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            String elementName = getElementName(element);
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(elementName + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void checkElementIsNotDisplayed(WebElement element) {
        Assert.assertFalse("Element is displayed", isElementDisplayed(element));
    }
    private String getElementName(WebElement element){
        try{
            return element.getAccessibleName();
        } catch (Exception e){
            return "";
        }
    }
    private void printErrorAndStopTest(Exception e) {
        System.out.println("Can not work with element");
        Assert.fail("Can not work with element");
    }
}
