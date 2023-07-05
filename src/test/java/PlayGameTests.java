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
@Feature("Playing games")
public class PlayGameTests extends BaseTest {

    @Parameters({"login", "password"})
    @Step("Play real game on T1Mobile")
    @Test(description = "Play real game on T1Mobile")
    @Description("Real game opens")
    public void playRealT1MobileTest(String login, String password) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        refresh();
        actions.waitAndClick("Click on Game Play button", homePage.getBookOfDeadRealGameButton());
        actions.waitAndClick("Click Game Icon on Hover Mode", homePage.getHoverStateIcon());
        assertions.assertOneOfElementsIsPresent("Game frame is loaded", gamesPage.getGameIFrame(), gamesPage.getPngContainer());
    }

    @Parameters({"login", "password"})
    @Step("Close game test")
    @Test(description = "Close game test")
    @Description("Close game test")
    public void closeGamePostLoginT1MobileTest(String login, String password) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        refresh();
        actions.waitAndClick("Click on Game Play button", homePage.getBookOfDeadRealGameButton());
        actions.waitAndClick("Click Game Icon on Hover Mode", homePage.getHoverStateIcon());
        assertions.assertOneOfElementsIsPresent("Game frame is loaded", gamesPage.getGameIFrame(), gamesPage.getPngContainer());
        actions.waitAndClick("Click Close Game button", homePage.getClosePariplayGameButton());
        assertions.assertElementPresent("Lobby side menu is presented", header.getBurgerIcon());
    }
}