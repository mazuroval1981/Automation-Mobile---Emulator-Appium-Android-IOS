import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestListenerAdapter.class)
@Epic("Mobile")
@Feature("Banners click tests")
public class BannersTests extends BaseTest {

    @Parameters("url")
    @Step("Carousel click pre-login")
    @Test(description = "Carousel click pre-login")
    @Description("Carousel click pre-login")
    public void carouselClickPreloginTest(String url) {
        actions.waitAndClick("Click on carousel", homePage.getCarouselPrelogin());
        assertions.assertElementPresent("Login widget is shown", loginForm.getLoginField());
        assertions.assertURL("URL is correct", url);
    }

    @Parameters({"login", "password"})
    @Step("Carousel click post-login")
    @Test(description = "Carousel click post-login")
    @Description("Carousel click post-login")
    public void carouselClickPostloginTTest(String login, String password) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        refresh();
        actions.waitAndClick("Click on carousel", homePage.getCarouselPrelogin());
        assertions.assertOneOfElementsIsPresent("Instant game is shown", gamesPage.getGameIFrame(), depositForm.getCloseDepositForm());
    }
}
