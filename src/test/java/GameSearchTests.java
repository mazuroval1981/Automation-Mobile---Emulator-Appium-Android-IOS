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
@Feature("Game search test")
public class GameSearchTests extends BaseTest {

    @Step("Game search test")
    @Test(description = "Game search test")
    @Description("Game search test")
    public void gameSearchTest() {
        actions.waitAndClickOrSkipIfNoElement("Close cookie", homePage.getCloseCookieBannerButton());
        actions.waitAndClick("Click Search", sideMenu.getGameSearchButton());
        actions.inputData("Type game name", sideMenu.getGameSearchButton(), Data.GAME_TO_SEARCH);
        assertions.assertElementPresent("Correct search result is shown", sideMenu.getGameSearchResultOnSideMenu());
    }
}