package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class PromotionsPage extends BaseClass {

    public PromotionsPage(WebDriver driver) {super(driver);}

    @FindBy(css = "promotions-buner__title")
    private WebElement singlePromotion;
    private By singlePromotionBy = By.xpath("//div[@class='promotion-block'][1]//a[@class='read-more fifth-bgcolor primary-textcolor']");

    @FindBy(xpath = "//div[@class='promotions-item'][1]//div[@class='promotion-cta-button']")
    private WebElement playNowButton;


    @FindBy(xpath = "//div[@class='promotions-item'][1]//h5")
    private WebElement seeFullTermsLink;

    @FindBy(xpath = "//h4[@class='global-text-color-settings']")
    private WebElement termsAndConditions;

    @FindBy(xpath = "//div[@class='tc-title collapsed']")
    private WebElement oLdTermsAndConditions;


    public WebElement getTermsAndConditions() {return termsAndConditions;}

    public By getSinglePromotionBy() { return singlePromotionBy; }

    public WebElement getPlayNowButton() { return playNowButton; }

    public WebElement getSeeFullTermsLink() { return seeFullTermsLink; }

    public WebElement getOLdTermsAndConditions() {return oLdTermsAndConditions;}

    public WebElement getSinglePromotion() {return singlePromotion;}
}
