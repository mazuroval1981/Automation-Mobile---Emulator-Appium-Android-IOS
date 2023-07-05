import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListenerAdapter.class)
@Epic("Mobile")
@Feature("More Games Tests")
@Test(description = "More Games button click loads more games")

public class MoreGamesButtonTests extends BaseTest {


    @Step("More Games button click loads more games")
    @Test(description = "More Games button click loads more games")
    @Description("Checking that More Games button click loads more games")
    public void moreGamesButtonT1MobileTest() {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.getGamesAmountBeforeMoreGamesButtonClick(homePage.getGameItemLocator());
        actions.waitAndClick("Click More Games button", homePage.getMoreGamesButton());
        sleep(300);
        homePage.getGamesAmountAfterMoreGamesButtonClick(homePage.getGameItemLocator());
        assertions.amountIsIncreased(homePage.getGamesAmountBeforeMoreGamesClick(), homePage.getGamesAmountAfterMoreGamesClick());
    }
}
