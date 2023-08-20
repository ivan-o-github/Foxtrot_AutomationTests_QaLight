package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.Footer;

public abstract class ParentPageWithHeaderAndFooter extends ParentPageWithHeader {
    Footer footer;

    public ParentPageWithHeaderAndFooter(WebDriver webDriver) {
        super(webDriver);
    }

    public Footer getFooter() {
        return new Footer(webDriver);
    }
}
