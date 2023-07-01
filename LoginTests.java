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
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    @Parameters({"login", "password", "url"})
    @Step("Login")
    @Test(description = "Login")
    @Description("Successful login")
    public void loginTest(String login, String password, String url) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        actions.waitAndClick("Click on Login button", header.getLoginButton());
        actions.inputData("Input login", loginForm.getLoginField(), login);
        actions.inputData("Input password", loginForm.getPasswordField(), password);
        actions.waitAndClick("Click on 'Login' button", loginForm.getLoginButtonAtLoginForm());
        assertions.assertElementPresent("Assert 'Deposit' button is present", header.getDepositButton());
        assertions.assertURL("URL is correct", url);
    }

    @Parameters({"login", "password", "url"})
    @Step("Logout")
    @Test(description = "Logout")
    @Description("Successfully logged out")
    public void logoutTest(String login, String password, String url) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        refresh();
        header.clickOnHeaderElement("Click on burger icon", header.getBurgerIcon());
        actions.waitAndClick("Click on Settings button", header.getSettingsButton());
        actions.waitAndClick("Click on logout button", sideMenu.getLogoutButton());
        sleep(10000);
        assertions.assertElementPresent("Login button is displayed",header.getLoginButton());
        assertions.assertURL("URL is correct", url);
    }
}
