package regionalityTests;

import baseTest.BaseTest;
import org.junit.Test;

public class WorkingWithRegionalityPopup extends BaseTest {
    @Test
    public void acceptingDefinedCity() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsDisplayed()
                .acceptCity()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsNotDisplayed()
                .getHeader()
                .checkIfCityFromHeaderIsMatchingChosenCity("Київ");
    }

    @Test
    public void closingPopup() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsDisplayed()
                .closePopup()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsNotDisplayed()
                .getHeader()
                .checkIfCityFromHeaderIsDefault();
    }

    @Test
    public void choosingLvivOption() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsDisplayed()
                .choosingLviv()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsNotDisplayed()
                .getHeader()
                .checkIfCityFromHeaderIsMatchingChosenCity("Львів");
    }

    @Test
    public void definingYourCityAfterChoosingWrongOne() throws InterruptedException {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsDisplayed()
                .choosingLviv()
                .getHeader()
                .getRegionalityPopup()
                .checkIfRegionalityPopupIsNotDisplayed()
                .getHeader()
                .checkIfCityFromHeaderIsMatchingChosenCity("Львів")
                .getHeader()
                .callRegionalityPopupByClickingCityTitleInHeader()
                .defineCity()
                .checkIfDefinedCityEqualsKyiv()
                .checkIfRegionalityPopupIsDisplayed();
    }
}
