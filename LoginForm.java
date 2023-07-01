package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class LoginForm extends BaseClass {
    public LoginForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButtonAtLoginForm;

    public WebElement getLoginField() {return loginField;}

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButtonAtLoginForm() {
        return loginButtonAtLoginForm;
    }
}
