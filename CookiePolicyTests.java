import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testsInfo.Data;

@Listeners(TestListenerAdapter.class)
@Epic("Mobile")
@Feature("Cookie Policy Tests")
@Test(description = "Cookie Policy is presented on all pages and has correct link")
public class CookiePolicyTests extends BaseTest {

    @Step("Click on Cookie Policy")
    @Test(description = "Click on Cookie Policy is opening Privacy pop-up")
    @Description("Click on Cookie Policy is opening Privacy pop-up")
    public void clickCookiePolicyOpensPrivacyPopupTest() {
        deleteAllCookies();
        refresh();
        assertions.assertElementPresent("Cookie Policy is presented", homePage.getCookiePolicy());
        actions.waitAndClick("Click on Cookie Policy", homePage.getCookiePolicy());
        sleep(5000);
        assertions.containTextFromElement("Privacy Title is presented", innerPages.getInfoPageTitle(), Data.PRIVACY_POPUP_TITLE);
    }

    @Step("Close Cookie Policy")
    @Test(description = "Click Close on Cookie Policy closes Cookie Policy")
    @Description("Click Close on Cookie Policy closes Cookie Policy")
    public void clickCloseClosesCookiePolicyTest() {
        deleteAllCookies();
        refresh();
        assertions.assertElementPresent("Cookie Policy is presented", homePage.getCookiePolicy());
        actions.waitAndClick("Close Cookie", homePage.getCloseCookieBannerButton());
        sleep(1000);
        assertions.assertElementIsNotPresent("CookiePolicy is not presented", homePage.getCookiePolicyBy());
    }
}
