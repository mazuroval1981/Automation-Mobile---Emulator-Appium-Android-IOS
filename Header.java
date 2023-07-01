package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Actions;
import utilities.BaseClass;

public class Header extends BaseClass {
    public Header(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//button[@class='btn btn__transparent btn__login']")
    private WebElement LoginButton;
    @FindBy(xpath = "//button[@class='btn btn__signup']")
    private WebElement registrationButton;
    @FindBy(xpath = "//div[@class='balance__account']")
    private WebElement depositButton;
    @FindBy(xpath = "//a[@id='nsb-toggle']")
    private WebElement burgerIcon;
    @FindBy(xpath ="//div[@class='header__container']//div[@class='header-logo__img']")
    private  WebElement logoButton;
    @FindBy(xpath ="//div[@class='asg-left-menu__widget asg-context-menu ']")
    private  WebElement SettingsButton;

    @Step("{step}")
    public void clickOnHeaderElement(String step, WebElement element){
        actions.waitAndClick(step, element);
    }

    public WebElement getLoginButton() {return LoginButton;}
    public WebElement getDepositButton() {return depositButton;}
    public WebElement getRegistrationButton() {return registrationButton;}
    public WebElement getLogoButton() { return logoButton;}
    public WebElement getBurgerIcon() {return burgerIcon;}
    public WebElement getSettingsButton() {return SettingsButton;}
}
