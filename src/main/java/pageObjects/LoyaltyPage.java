package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class LoyaltyPage extends BaseClass {
    public LoyaltyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='promotionPage RewardsProgramme']")
    private WebElement loyaltyPageSection;

    public WebElement getLoyaltyPageSection() {
        return loyaltyPageSection;
    }
}

