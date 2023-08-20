package pages;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends ActionsWithElements {
    final static String BASE_URL = "https://www.foxtrot.com.ua/uk";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkUrl(String url) {
        Assert.assertEquals("Url is not expected", url, webDriver.getCurrentUrl());
    }
}
