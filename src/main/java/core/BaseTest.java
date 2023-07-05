package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.*;
import utilities.Actions;
import utilities.Assertions;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AndroidDriver androidDriver;
    protected IOSDriver iosDriver;
    public Assertions assertions;
    public Actions actions;
    public LoginForm loginForm;
    public Header header;
    public HomePage homePage;
    public SideMenu sideMenu;
    public Footer footer;
    public InnerPages innerPages;
    public GamesPage gamesPage;
    public FooterRegulationPages footerRegulationPages;
    public PromotionsPage promotionsPage;
    public RegistrationForm registrationForm;
    public LoyaltyPage loyaltyPage;
    public DepositForm depositForm;
    public AccountDetailsPage accountDetailsPage;
    public RegilyWidgets regilyWidgets;


    @Parameters("url")
    @BeforeMethod
    @Step("Preconditions")
    public void setUp(String url) throws MalformedURLException {

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "iPhone(2)");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("udid", "00008020-001C6154360B002E");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("platformVersion", "15.7");
            caps.setCapability("browserName", "Safari");
            caps.setCapability("useNewWDA", true);
            iosDriver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
        }
        catch (AssertionError e) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "GalaxyS20");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("deviceID", "2aacf368713f7ece");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "10");
            caps.setCapability("browserName", "Chrome");
            androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        }

        goToWebPage("Go to home page" + url, url);
        deleteAllCookies();
        refresh();
        System.out.println("open page");

        if(androidDriver != null){
            assertions = new Assertions(androidDriver);
            actions = new Actions(androidDriver);
            loginForm = new LoginForm(androidDriver);
            header = new Header(androidDriver);
            homePage = new HomePage(androidDriver);
            sideMenu = new SideMenu(androidDriver);
            footer = new Footer(androidDriver);
            innerPages = new InnerPages(androidDriver);
            gamesPage = new GamesPage(androidDriver);
            footerRegulationPages = new FooterRegulationPages(androidDriver);
            promotionsPage = new PromotionsPage(androidDriver);
            registrationForm = new RegistrationForm(androidDriver);
            loyaltyPage = new LoyaltyPage(androidDriver);
            depositForm = new DepositForm(androidDriver);
            accountDetailsPage = new AccountDetailsPage(androidDriver);
            regilyWidgets = new RegilyWidgets(androidDriver);
        }

        else {
            assertions = new Assertions(iosDriver);
            actions = new Actions(iosDriver);
            loginForm = new LoginForm(iosDriver);
            header = new Header(iosDriver);
            homePage = new HomePage(iosDriver);
            sideMenu = new SideMenu(iosDriver);
            footer = new Footer(iosDriver);
            innerPages = new InnerPages(iosDriver);
            gamesPage = new GamesPage(iosDriver);
            footerRegulationPages = new FooterRegulationPages(iosDriver);
            promotionsPage = new PromotionsPage(iosDriver);
            registrationForm = new RegistrationForm(iosDriver);
            loyaltyPage = new LoyaltyPage(iosDriver);
            depositForm = new DepositForm(iosDriver);
            accountDetailsPage = new AccountDetailsPage(iosDriver);
            regilyWidgets = new RegilyWidgets(iosDriver);
        }

        goToWebPage("Go to home page" + url, url);
        System.out.println("open page");

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void afterTest(WebDriver driver, ITestResult result) {
        String className = String.valueOf(result.getTestClass()).replaceAll("TestClass name=class ", "");
        String testName = result.getName();
        String screenName = className + testName;

        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshotPNG(driver);
        }
        driver.quit();
    }

    @Step("{step}")
    public void goToWebPage(String step, String url) {
        if(androidDriver != null){
            androidDriver.get(url);
        }
        else {
            iosDriver.get(url);
        }
        sleep(3000);
    }


    @AfterMethod
    public void after(ITestResult result) {
        if(androidDriver != null){
            afterTest(androidDriver, result);
        }
        else{
            afterTest(iosDriver, result);
        }
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void refresh() {
        if(androidDriver != null){
            androidDriver.navigate().refresh();
        }
        else{
            iosDriver.navigate().refresh();
        }
        sleep(3000);
    }

    public void deleteAllCookies() {
        if(androidDriver != null){
            androidDriver.manage().deleteAllCookies();
        }
        else{
            iosDriver.manage().deleteAllCookies();
        }
        refresh();
    }
}