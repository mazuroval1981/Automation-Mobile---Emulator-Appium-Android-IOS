package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class SideMenu extends BaseClass {

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='sb-menu fifth-bgcolor']//li[@class='item-logout']//a")
    private WebElement logoutButton;
    @FindBy(xpath = "//i[@class='icon-promotion-menu']")
    private WebElement promotionsLink;
    @FindBy(xpath = "//div[@class='log-out']//li[@class='side-accountDetails ']//a")
    private WebElement accountDetailsButton;
    @FindBy(xpath = "//div[@class='asg-left-menu__item asg-left-menu__item--contact-us']")
    private WebElement helpButton;
    @FindBy(xpath = "//div[@class='header__center_show']//input")
    private WebElement gameSearchButton;
    @FindBy(xpath = "//div[@class='search-result__imege']")
    private WebElement gameSearchResultOnSideMenu;

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getPromotionsLink() {
        return promotionsLink;
    }

    public WebElement getAccountDetailsButton() {
        return accountDetailsButton;
    }

    public WebElement getHelpButton() {return helpButton;}

    public WebElement getGameSearchResultOnSideMenu () { return gameSearchResultOnSideMenu;}

    public WebElement getGameSearchButton() {return gameSearchButton;}
}
