package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import utilities.Actions;
import utilities.Assertions;
import utilities.BaseClass;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);
    Header header = new Header(driver);
    LoginForm loginForm = new LoginForm(driver);
    Assertions assertions = new Assertions(driver);
    private int gamesAmountBeforeMoreGamesClick;
    private int gamesAmountAfterMoreGamesClick;


    @FindBy(xpath = "//div[@id='content-banner']//button")
    private WebElement closeCookieBannerButton;

    @FindBy(xpath = "//div[@class='carousel-buner__item-bg']//button[@class='btn btn-light']")
    private WebElement carouselPrelogin;

    @FindBy(xpath = "//section[@class='home-section games-carousel'][1]")
    private WebElement gamesGrid;

    @FindBy(xpath = "//div[@class='sportbet-body']")
    private WebElement sportIframe;

    @FindBy(css = "intercom-messenger-frame")
    private WebElement chatBody;

    @FindBy(xpath = "//div[@aria-label='Open Intercom Messenger']")
    private WebElement chatIcon;

    @FindBy(xpath = "//div[@id='contact-us-main']")
    private WebElement contactUsWidget;

    @FindBy(xpath = "//a[@class='slide-menu__link link-items']//i[@class='icon-support-chat-menu']")
    private WebElement supportButton;

    @FindBy(xpath = "//img[@alt='Book of Dead']")
    private WebElement bookOfDeadRealGameButton;

    @FindBy(xpath = "//div[@class='casino-thumbnail__hover']")
    private WebElement hoverStateIcon;

    @FindBy(xpath = "//div[@id='content-banner']//a")
    private WebElement cookiePolicy;
    private By cookiePolicyBy = By.xpath("//div[@id='content-banner']//a");

    @FindBy(css = "btn btn__sm btn-more")
    private WebElement moreGamesButton;
    private By gameItemLocator = By.xpath("//div[@class='casino-vertical-grid__item casino-vertical-grid__item--small ']");

    @FindBy(xpath = "//div[@class='mwc-fullscreen-ig-close-button']")
    private WebElement closePariplayGameButton;

    @FindBy(xpath = "//i[@class='icon-menu']")
    private WebElement footerMenuButton;

    @FindBy(xpath = "//i[@class='icon-favorited-menu']")
    private WebElement favoritesButton;

    @FindBy(xpath = "//i[@class='icon-rewards-menu']")
    private WebElement rewardsProgrammeButton;

    @FindBy(xpath = "//i[@class='icon-about-us-menu']")
    private WebElement aboutUsButton;

    @Step("{step}")
    public void login(String step, String login, String password){
        header.clickOnHeaderElement("Click on Login button",header.getLoginButton());
        actions.inputData("Input login", loginForm.getLoginField(), login);
        actions.inputData("Input password", loginForm.getPasswordField(), password);
        actions.waitAndClick("Click on 'Login' button", loginForm.getLoginButtonAtLoginForm());
        sleep(9000);
        assertions.assertElementPresent("NG is loaded", header.getDepositButton());
    }


    @Step("Get games number displayed before More Games click")
    public void getGamesAmountBeforeMoreGamesButtonClick(By locator){
        gamesAmountBeforeMoreGamesClick = actions.getGamesAmount(locator);
    }

    @Step("Get games number displayed after More Games click")
    public void getGamesAmountAfterMoreGamesButtonClick(By locator){
        gamesAmountAfterMoreGamesClick = actions.getGamesAmount(locator);
    }

    public WebElement getCloseCookieBannerButton() {return closeCookieBannerButton;}

    public WebElement getCarouselPrelogin() {return carouselPrelogin;}

    public WebElement getSportIframe() {return sportIframe;}

    public WebElement getContactUsWidget() {return contactUsWidget;}

    public WebElement getGamesGrid() {return gamesGrid;}

    public WebElement getBookOfDeadRealGameButton() {return bookOfDeadRealGameButton;}

    public WebElement getCookiePolicy() { return cookiePolicy; }

    public By getCookiePolicyBy() { return cookiePolicyBy; }

    public WebElement getMoreGamesButton() {return moreGamesButton;}

    public By getGameItemLocator() {return gameItemLocator;}

    public Actions getActions() {return actions;}

    public int getGamesAmountBeforeMoreGamesClick() {return gamesAmountBeforeMoreGamesClick;}

    public int getGamesAmountAfterMoreGamesClick() {return gamesAmountAfterMoreGamesClick;}

    public WebElement getClosePariplayGameButton() {return closePariplayGameButton;}

    public WebElement getHoverStateIcon() {return hoverStateIcon;}

    public WebElement getSupportButton() {return supportButton;}

    public WebElement getChatIcon() {return chatIcon;}

    public WebElement getChatBody() {return chatBody;}

    public WebElement getFooterMenuButton() {return footerMenuButton;}

    public WebElement getFavoritesButton() {return favoritesButton;}

    public WebElement getRewardsProgrammeButton() {return rewardsProgrammeButton;}

    public WebElement getAboutUsButton() {return aboutUsButton;}
}
