package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class AccountDetailsPage extends BaseClass {
    public AccountDetailsPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//span[@class='mwc-account-section-title-text ng-binding' and contains(text(), 'Account Details')]")
    private WebElement accountDetails;

    public WebElement getAccountDetails() {
        return accountDetails;
    }
}
