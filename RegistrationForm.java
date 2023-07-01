package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class RegistrationForm extends BaseClass {
    public RegistrationForm(WebDriver driver){super(driver);}

    @FindBy(xpath="//input[@type='email']")
    private WebElement emailField;

    @FindBy(css = "#username")
    private WebElement loginField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='submitRegStep1']")
    private WebElement nextButton;

    @FindBy(css = "#firstname")
    private WebElement firstNameField;

    @FindBy(css = "#lastName")
    private WebElement lastNameField;

    @FindBy(css = "#birthdayDay")
    private WebElement birthdayDayField;

    @FindBy(css = "#birthdayMonth")
    private WebElement birthdayMonthField;

    @FindBy(css = "#birthdayYear")
    private WebElement birthdayYearField;

    @FindBy(css = "#address")
    private WebElement addressField;

    @FindBy(css = "#city")
    private WebElement cityField;

    @FindBy(css = "#zipCode")
    private WebElement zipCodeField;

    @FindBy(css = "#cellPhone")
    private WebElement cellPhoneField;

    @FindBy(xpath = "//i[@class='mwc-glyphicon mwc-checkbox__icon mwc-icon-uncheck']")
    private WebElement termsCheckbox;

    @FindBy(css = "#submitRegStep2")
    private WebElement openAccountButton;


    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getBirthdayDayField() {
        return birthdayDayField;
    }

    public WebElement getBirthdayMonthField() {
        return birthdayMonthField;
    }

    public WebElement getBirthdayYearField() {
        return birthdayYearField;
    }

    public WebElement getAddressField() {
        return addressField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public WebElement getCellPhoneField() {
        return cellPhoneField;
    }

    public WebElement getTermsCheckbox() {
        return termsCheckbox;
    }

    public WebElement getOpenAccountButton() {
        return openAccountButton;
    }
}
