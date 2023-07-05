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
@Feature("Promotion tests")
public class PromotionsTests extends BaseTest {

    @Parameters("url")
    @Step("Promotions page opens and displays fine")
    @Test(description = "Promotions page opens and displays fine")
    @Description("Checking that Promotions display successfully")
    public void promotionsT1MobileTest(String url) {
        actions.waitAndClick("Close Cookie", homePage.getCloseCookieBannerButton());
        actions.waitAndClick("Click on footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Click on Promotions link",sideMenu.getPromotionsLink());
        assertions.assertElementPresent("Single promotions are displayed", promotionsPage.getSinglePromotion());
        assertions.assertURL("URL is correct", url + Urls.PROMOTIONS_PAGE_URL);
    }

    @Parameters({"url", "login", "password"})
    @Step("Promotion Card Play Now button click Post Login returns to Home page")
    @Test(description = "Promotion Card Play Now button click Post Login returns to Home page")
    @Description("Click on Promotion Card Play Now button Post Login returns to Home page")
    public void promotionCardPlayNowButtonPostloginT1MobileTest(String url, String login, String password) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        goToWebPage("Go to Promotions page", url + Urls.PROMOTIONS_PAGE_URL);
        actions.waitAndClick("Click on Play Now button Post Login on Promotion Card", promotionsPage.getPlayNowButton());
        assertions.assertElementIsNotPresent("User left Promotions page", promotionsPage.getSinglePromotionBy());
    }

    @Parameters({"url", "login", "password"})
    @Step("Promotion Card See Full terms link Post Login redirect to the single promotions page")
    @Test(description = "Promotion Card See Full terms link Post Login redirect to the single promotions page")
    @Description("Checking that See Full terms link Post Login redirect to the single promotions page")
    public void promotionCardSeeFullTermsLinkPostloginT1MobileTest(String url, String login, String password) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login to T1", login, password);
        goToWebPage("Go to Promotion Page", url + Urls.PROMOTIONS_PAGE_URL);
        actions.waitAndClick("Click on See Full terms link  Post Login on Promotion Card", promotionsPage.getSeeFullTermsLink());
        assertions.assertOneOfElementsIsPresent("Terms and conditions are shown", promotionsPage.getTermsAndConditions(), promotionsPage.getOLdTermsAndConditions());
    }
}
