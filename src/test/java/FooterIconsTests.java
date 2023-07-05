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
@Feature("Footer icons tests")

public class FooterIconsTests extends BaseTest {

    @Parameters("url")
    @Step("MGA footer icons are displayed")
    @Test(description = "MGA footer icons are displayed")
    @Description("MGA footer icons are displayed")
    public void mgaFooterIconsTest(String url) {
        goToWebPage("Go to MGA page", url + Urls.MGA_IP);
        assertions.assertElementPresentInDom("Underage link is present", footer.getUnderAgeIconBy());
        assertions.assertElementPresentInDom("ProgressPlay link is present", footer.getProgressplayIconBy());
        assertions.assertElementPresentInDom("GamblersAnonymous link is present", footer.getBeGambleAwareIconBy());
        assertions.assertElementPresentInDom("GameCare link is present", footer.getPciIconBy());
        assertions.assertElementPresentInDom("Cetigo link is present", footer.getSectigoIconBy());
        assertions.assertElementPresentInDom("MGA link is present", footer.getMgaIconBy());
    }

    @Parameters("url")
    @Step("Germany footer icons are displayed")
    @Test(description = "Germany footer icons are displayed")
    @Description("Germany footer icons are displayed")
    public void germanyFooterIconsTest(String url) {
        goToWebPage("Go to Germany page", url + Urls.GERMAN_IP);
        assertions.assertElementPresentInDom("Underage link is present", footer.getUnderAgeIconBy());
        assertions.assertElementPresentInDom("ProgressPlay link is present", footer.getProgressplayIconBy());
        assertions.assertElementPresentInDom("BeGambleAware link is present", footer.getBeGambleAwareIconBy());
        assertions.assertElementPresentInDom("GameCare link is present", footer.getPciIconBy());
        assertions.assertElementPresentInDom("MGA link is present", footer.getMgaIconBy());
    }

    @Parameters("url")
    @Step("Finland footer icons are displayed")
    @Test(description = "Finland footer icons are displayed")
    @Description("Finland footer icons are displayed")
    public void finlandFooterIconsTest(String url) {
        goToWebPage("Go to Finland page", url + Urls.FINLAND_IP);
        assertions.assertElementPresentInDom("Underage link is present", footer.getUnderAgeIconBy());
        assertions.assertElementPresentInDom("GameCare link is present", footer.getPciIconBy());
        assertions.assertElementPresentInDom("ProgressPlay link is present", footer.getProgressplayIconBy());
        assertions.assertElementPresentInDom("BeGambleAware link is present", footer.getBeGambleAwareIconBy());
        assertions.assertElementPresentInDom("MGA link is present", footer.getMgaIconBy());
    }

    @Parameters("url")
    @Step("Norway footer icons are displayed")
    @Test(description = "Norway footer icons are displayed")
    @Description("Norway footer icons are displayed")
    public void norwayFooterIconsTest(String url) {
        goToWebPage("Go to Norway page", url + Urls.NORWAY_IP);
        assertions.assertElementPresentInDom("Underage link is present", footer.getUnderAgeIconBy());
        assertions.assertElementPresentInDom("GameCare link is present", footer.getPciIconBy());
        assertions.assertElementPresentInDom("ProgressPlay link is present", footer.getProgressplayIconBy());
        assertions.assertElementPresentInDom("BeGambleAware link is present", footer.getBeGambleAwareIconBy());
        assertions.assertElementPresentInDom("MGA link is present", footer.getMgaIconBy());
    }

    @Parameters("url")
    @Step("Regulation sites open fine")
    @Test(description = "Regulation sites open fine")
    @Description("Regulation sites open fine")
    public void regulationSitesWorkTest(String url) {
        goToWebPage("Go to MGA page", Urls.MGA);
        assertions.assertElementPresent("MGA page is displayed", footerRegulationPages.getMgaLogo());
        goToWebPage("Go to Progressplay page", Urls.PROGRESSPLAY);
        assertions.assertElementPresent("Progressplay page is displayed", footerRegulationPages.getProgressplayLogo());
        goToWebPage("Go to PCI page", Urls.PCI);
        actions.waitAndClickOrSkipIfNoElement("Click close cookies", footerRegulationPages.getAcceptCookiesOnPciPage());
        assertions.assertElementPresent("PCI page is displayed", footerRegulationPages.getPciHeader());
        goToWebPage("Go to Begambleawere page", Urls.BEGAMBLEAWERE);
        assertions.assertElementPresent("Begambleawere page is displayed", footerRegulationPages.getBegambleawereLogo());
        goToWebPage("Go to GamStop page", Urls.GAM_STOP);
        actions.waitAndClickOrSkipIfNoElement("Click Close Cookies", footerRegulationPages.getAcceptCookiesOnGamestopPage());
        assertions.assertElementPresent("GamStop page is displayed", footerRegulationPages.getGamStopLogo());
        goToWebPage("Go to Underage page", url + Urls.UNDERAGE);
        assertions.containTextFromElement("Underage title is shown", innerPages.getInfoPageTitle(), Data.UNDERAGE_TITLE);
    }
}
