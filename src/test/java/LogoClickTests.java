import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testsInfo.Urls;

@Listeners(TestListenerAdapter.class)
@Epic("Mobile")
@Feature("Logo Click Tests")
@Test(description = "Click on Logo Returns to Home Page")
public class LogoClickTests extends BaseTest {

    @Parameters("url")
    @Step("Click on Logo on Home Page Returns to Home Page")
    @Test(description = "Click on Logo on Home Page Returns to Home Page")
    @Description("Click on Logo on Home Page Returns to Home Page")
    public void clickLogoOnHomePageTest(String url) {
        actions.waitAndClick("Click on Logo", header.getLogoButton());
        sleep(1000);
        assertions.assertURL("URL is correct", url);
    }

    @Parameters("url")
    @Step("Click Logo on Promotions Page Returns to Home Page")
    @Test(description = "Click Logo on Promotions Page Returns to Home Page")
    @Description("Click Logo on Promotions Page Returns to Home Page")
    public void clickLogoOnPromotionsPageT1MobileTest(String url) {
        goToWebPage("Go to Promotion Page", url + Urls.PROMOTIONS_PAGE_URL);
        actions.waitAndClick("Click on Logo", header.getLogoButton());
        assertions.assertURL("URL is correct", url);
    }

    @Parameters("url")
    @Step("Click on Logo on Sport Page")
    @Test(description = "Logo Click on Sport Page")
    @Description("Click on Logo on Sport Page returns to Home Page")
    public void clickLogoOnSportPageT1MobileTest(String url) {
        goToWebPage("Go to Sport Page", url + Urls.SPORT_PAGE_URL);
        actions.waitAndClick("Click on Logo", header.getLogoButton());
        sleep(1000);
        assertions.assertElementPresent("Casino lobby is loaded", homePage.getGamesGrid());
    }
}