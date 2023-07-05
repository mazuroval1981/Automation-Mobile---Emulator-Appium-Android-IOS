package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class DepositForm extends BaseClass {
    public DepositForm(WebDriver driver){super(driver);}
    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDepositForm;

    public WebElement getCloseDepositForm() {
        return closeDepositForm;
    }
}
