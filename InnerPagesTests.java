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
@Feature("Inner pages tests")
public class InnerPagesTests extends BaseTest {

    @Parameters("url")
    @Step("Info pages test")
    @Test(description = "Info pages test")
    @Description("Info pages test")
    public void InfoPagesTest(String url) {
        actions.waitAndClickOrSkipIfNoElement("Close Cookie", homePage.getCloseCookieBannerButton());
        goToWebPage("Open About Us Info page",url+ Urls.ABOUT_US_PAGE_URL );
        assertions.containTextFromElement("About Us title is shown", innerPages.getInfoPageTitle(), Data.ABOUT_US_TITLE );
        assertions.containTextFromElement("About Us text is shown", innerPages.getInfoPageText(), Data.ABOUT_US_TEXT );

        goToWebPage("Open Terms Info page",  url+ Urls.TERMS_PAGE_URL );
        assertions.containTextFromElement("Terms title is shown", innerPages.getInfoPageTitle(), Data.TERMS_TITLE );
        assertions.containTextFromElement("Terms text is shown", innerPages.getTermsPageText(), Data.TERMS_TEXT );

        goToWebPage("Open Privacy Info page",  url+ Urls.PRIVACY_PAGE_URL );
        assertions.containTextFromElement("Privacy title is shown", innerPages.getInfoPageTitle(), Data.PRIVACY_TITLE );
        assertions.containTextFromElement("Privacy text is shown", innerPages.getInfoPageText(), Data.PRIVACY_TEXT );

        goToWebPage("Open Responsible Gaming Info page",  url+ Urls.RESPONSIBLE_PAGE_URL );
        assertions.containTextFromElement("Responsible Gaming title is shown", innerPages.getInfoPageTitle(), Data.RESPONSIBLE_GAMING_TITLE );
        assertions.containTextFromElement("Responsible Gaming text is shown", innerPages.getInfoPageText(), Data.RESPONSIBLE_GAMING_TEXT );

        goToWebPage("Open Deposit Info page",  url+ Urls.DEPOSIT_PAGE_URL);
        assertions.containTextFromElement("Deposit title is shown", innerPages.getInfoPageTitle(), Data.DEPOSIT_TITLE );
        assertions.containTextFromElement("Deposit text is shown", innerPages.getInfoPageText(), Data.DEPOSIT_TEXT );

        goToWebPage("Open Cash Out Info page",  url+ Urls.CASHOUT_PAGE_URL );
        assertions.containTextFromElement("Cash Out title is shown", innerPages.getInfoPageTitle(), Data.CASHOUT_TITLE );
        assertions.containTextFromElement("Cash Out text is shown", innerPages.getInfoPageText(), Data.CASHOUT_TEXT );
    }
}