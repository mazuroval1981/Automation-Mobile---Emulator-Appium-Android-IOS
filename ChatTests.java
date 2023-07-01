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
@Feature("Chat tests")
public class ChatTests extends BaseTest {

    @Parameters({"login", "password", "url"})
    @Step("Chat opens successfully in post-login")
    @Test(description = "Chat opens successfully in post-login")
    @Description("Chat opens successfully in post-login")
    public void chatOpensSuccessfullyInPostloginTest(String login, String password, String url) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        refresh();
        actions.waitAndClick("Click bottom menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Click Help", homePage.getSupportButton());
        actions.waitAndClick("Click Help", homePage.getChatIcon());
        assertions.assertElementPresent("Chat is opened successfully", homePage.getChatBody());
        assertions.assertURL("URL is correct", url);
    }
}