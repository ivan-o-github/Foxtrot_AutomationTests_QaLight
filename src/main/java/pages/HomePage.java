package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeaderAndFooter {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage openHomePage() {
        openPage(BASE_URL);
        checkUrl(BASE_URL);
        return this;
    }

    public HomePage openHomePageAndCloseRegionalityPopup() {
        openPage(BASE_URL);
        checkUrl(BASE_URL);
        getHeader().getRegionalityPopup().closePopup();
        return this;
    }
}
