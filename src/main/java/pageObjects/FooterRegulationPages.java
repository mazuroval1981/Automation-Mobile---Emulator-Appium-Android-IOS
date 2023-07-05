package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class FooterRegulationPages extends BaseClass {
    public FooterRegulationPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header//img[@alt='PCI Security Standards Council Registered']")
    private WebElement pciHeader;

    @FindBy(xpath = "//button[@id='ccc-notify-accept']")
    private WebElement acceptCookiesOnPciPage;

    @FindBy(xpath = "//button[@id='cookie-consent-accept']")
    private WebElement acceptCookiesOnGamestopPage;

    @FindBy(xpath = "//div[@id='block-begambleaware-branding']")
    private WebElement begambleawereLogo;

    @FindBy(xpath = "//div[@class='lga-logo-container']")
    private WebElement mgaLogo;

    @FindBy(xpath = "//img[@class='attachment-full size-full wp-image-1460']")
    private WebElement progressplayLogo;

    @FindBy(xpath = "//a[@class='logo']//img")
    private WebElement gamStopLogo;


    public WebElement getMgaLogo() {
        return mgaLogo;
    }

    public WebElement getGamStopLogo() {
        return gamStopLogo;
    }

    public WebElement getProgressplayLogo() {return progressplayLogo;}

    public WebElement getAcceptCookiesOnPciPage() {return acceptCookiesOnPciPage;}

    public WebElement getPciHeader() {return pciHeader;}

    public WebElement getBegambleawereLogo() {return begambleawereLogo;}

    public WebElement getAcceptCookiesOnGamestopPage() {return acceptCookiesOnGamestopPage;}
}
