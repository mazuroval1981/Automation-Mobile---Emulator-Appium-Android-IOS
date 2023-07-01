package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    int time = 60;

    public BaseClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));

    }

    @Step("Wait clickability of element")
    public void waitClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step("Wait visibility of element")
    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void refresh() {
        driver.navigate().refresh();
        sleep(1500);
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------WINDOWS ACTIONS-----------------------------------------------------------
    @Step("{step}")
    public static void openNewWindow(String step, WebDriver driver, String homePage) {
        Set<String> window = driver.getWindowHandles();
        Iterator iterator = window.iterator();
        String currentWindowId = "WIndow Not found";
        while (iterator.hasNext()) {
            currentWindowId = iterator.next().toString();

            if (!currentWindowId.equals(homePage)) driver.switchTo().window(currentWindowId);
        }
    }

    @Step("{step}")
    public void switchTabs(String step, int tabNumber) {
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabNumber));
        } catch (Exception e) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        }
    }

    @Step("{step}")
    public void closeTab(String step, WebDriver driver, int tabNumber) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabNumber));
            driver.close();
        } catch (Exception e) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        }
    }

    @Step("{step}")
    public void switchToForm(String step, WebElement element){
        driver.switchTo().frame(element);
    }

    @Step("{step}")
    public void switchToWindow(String step){
        for(String handles : driver.getWindowHandles()){
            driver.switchTo().window(handles);
        }
    }

    @Step("{step}")
    public void switchToHomeWindow(String step){
        driver.switchTo().defaultContent();
    }

    //---------------------------------------------RANDOMIZER-----------------------------------------------------------

    @Step("{step}")
    public static String random(String step, int min, int max) {
        int randomInt = (int) ((Math.random() * ((max - min) + 1)) + min);
        String numberString = Integer.toString(randomInt);
        return numberString;
    }
}
