import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testsInfo.Data;
import testsInfo.Urls;

@Listeners(TestListenerAdapter.class)
@Epic("Mobile")
@Feature("SideMenu tests")
public class SideMenuTests extends BaseTest {

    @Parameters("url")
    @Step("Favorites button test")
    @Test(description = "Favorites button click redirects to Favorites page")
    @Description("Favorites button click redirects to Favorites page")
    public void favoritesTest(String url) {
        actions.moveToElement("Move to footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Open footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Click Favorites", homePage.getFavoritesButton());
        assertions.containTextFromElement("Favorites title is shown", innerPages.getFavoritesPageTitle(), Data.FAVORITES_TITLE);
        assertions.assertURL("URL is correct", url + Urls.FAVOURITES_PAGE_URL);
    }

    @Parameters("url")
    @Step("Rewards programme button test")
    @Test(description = "Rewards programme button test")
    @Description("Rewards programme button click redirects to Rewards programme page")
    public void rewardsProgrammeButtonTest(String url) {
        actions.moveToElement("Move to footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Open footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Click Rewards Programme", homePage.getRewardsProgrammeButton());
        assertions.assertElementPresent("Rewards Programme is shown", loyaltyPage.getLoyaltyPageSection());
        assertions.assertURL("URL is correct", url);
    }

    @Parameters({"login", "password"})
    @Step("Contact Us button test")
    @Test(description = "Contact Us button test")
    @Description("Contact Us button test")
    public void contactUsButtonT1MobileTest(String login, String password) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        actions.moveToElement("Move to footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Click on burger icon", header.getBurgerIcon());
        actions.waitAndClick("Click on Help", sideMenu.getHelpButton());
        assertions.assertElementPresent("Contact Us widget is shown", homePage.getContactUsWidget());
    }

    @Parameters({"login", "password"})
    @Step("Account Details button test")
    @Test(description = "Account Details button test")
    @Description("Account Details button test")
    public void accountDetailsTest(String login, String password) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        homePage.login("Login", login, password);
        actions.moveToElement("Move to footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Click on burger icon", homePage.getFooterMenuButton());
        actions.waitAndClick("Click on Account Details", sideMenu.getAccountDetailsButton());
        assertions.assertElementPresent("Account Details are shown", accountDetailsPage.getAccountDetails());
    }

    @Parameters("url")
    @Step("Cashout button test")
    @Test(description = "Cashout button test")
    @Description("Cashout button test")
    public void aboutUsButtonTest(String url) {
        actions.moveToElement("Move to footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Open footer menu", homePage.getFooterMenuButton());
        actions.waitAndClick("Click About Us", homePage.getAboutUsButton());
        assertions.containTextFromElement("About Us title is shown", innerPages.getInfoPageTitle(), Data.ABOUT_US_TITLE );
        assertions.assertURL("URL is correct", url + Urls.ABOUT_US_PAGE_URL);
    }
}
