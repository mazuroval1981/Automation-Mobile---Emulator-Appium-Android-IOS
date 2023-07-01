package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;


public class InnerPages extends BaseClass {
    public InnerPages(WebDriver driver){super(driver);}

    @FindBy(xpath = "//h1")
    private WebElement infoPageTitle;

    @FindBy(xpath = "//h2")
    private WebElement favoritesPageTitle;

    @FindBy(xpath = "//div[@class='content-area']")
    private WebElement infoPageText;

    @FindBy(xpath = "//div[@class='panel__body terms-content']")
    private WebElement termsPageText;


    public WebElement getInfoPageTitle() {
        return infoPageTitle;
    }

    public WebElement getInfoPageText() {return infoPageText; }

    public WebElement getFavoritesPageTitle() {return favoritesPageTitle;}

    public WebElement getTermsPageText() {return termsPageText;}
}
