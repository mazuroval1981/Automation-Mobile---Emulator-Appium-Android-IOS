package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class GamesPage extends BaseClass {
    public GamesPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//div[@class='in-game-content-container']//iframe")
    private WebElement gameIFrame;

    @FindBy(xpath = "//div[@id='pngPreloaderWrapper']")
    private WebElement pngContainer;

    public WebElement getGameIFrame() { return gameIFrame; }

    public WebElement getPngContainer() {
        return pngContainer;
    }
}
