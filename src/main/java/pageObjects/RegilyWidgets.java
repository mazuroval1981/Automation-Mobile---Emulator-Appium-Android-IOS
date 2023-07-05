package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BaseClass;

public class RegilyWidgets extends BaseClass {
    public RegilyWidgets(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='regily-module in-view visible show-loader show-module']")
    private WebElement rotateYourDeviceMessage;

    public WebElement getRotateYourDeviceMessage() {return rotateYourDeviceMessage;}
}
