package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Actions;
import utilities.BaseClass;

public class Footer extends BaseClass {
    public Footer(WebDriver driver){super(driver);}
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//li[@class='AGE18']")
    private WebElement underAgeIcon;
    private By underAgeIconBy = (By.xpath("//li[@class='AGE18']"));

    @FindBy(xpath = "//li[@class='PCI']")
    private WebElement pciIcon;
    private By pciIconBy = (By.xpath("//li[@class='PCI']"));

    @FindBy(xpath = "//li[@class='SECTIGO']")
    private WebElement sectigoIcon;
    private By sectigoIconBy = (By.xpath("//li[@class='SECTIGO']"));

    @FindBy(xpath = "//li[@class='PBPROGRESSPLAY']")
    private WebElement progressplayIcon;
    private By progressplayIconBy = (By.xpath("//li[@class='PBPROGRESSPLAY']"));

    @FindBy(xpath = "//li[@class='MGA']")
    private WebElement mgaIcon;
    private By mgaIconBy = (By.xpath("//li[@class='MGA']"));

    @FindBy(xpath = "//li[@class='GAMBLEAWARE2']")
    private WebElement beGambleAwareIcon;
    private By beGambleAwareIconBy = (By.xpath("//li[@class='GAMBLEAWARE2']"));


    @FindBy(xpath = "//nav[@class='navbar-mobile']//i[@class='icon-sportbook-menu']")
    private WebElement sportButton;

    @Step("{step}")
    public void moveToFooterElement(String step, WebElement element){
        actions.moveToElement(step, element);
    }


    public WebElement getSportButton() {return sportButton;}

    public By getUnderAgeIconBy() {return underAgeIconBy;}

    public By getPciIconBy() {return pciIconBy;}

    public By getSectigoIconBy() {return sectigoIconBy;}

    public By getProgressplayIconBy() {return progressplayIconBy;}

    public By getMgaIconBy() {return mgaIconBy;}

    public By getBeGambleAwareIconBy() {return beGambleAwareIconBy;}
}

