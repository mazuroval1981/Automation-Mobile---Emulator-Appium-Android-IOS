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
@Feature("Categories tests")
public class CategoriesTests extends BaseTest {


    @Step("Casino games are shown")
    @Test(description = "Casino games are shown")
    @Description("Casino games are shown")
    public void CasinoGamesDisplayFineTest() {
        assertions.assertElementPresent("Casino games are shown", homePage.getGamesGrid());
    }

    @Step("Sport is shown")
    @Test(description = "Sport is shown")
    @Description("Sport is shown")
    public void sportDisplaysFineTest() {
        actions.waitAndClick("Click Sport", footer.getSportButton());
        assertions.assertElementPresent("Sport is shown", homePage.getSportIframe());
    }
}
