package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.fail;

public class Actions extends BaseClass {
    public Actions(WebDriver driver) {
        super(driver);
    }

    @Step("{step}")
    public void inputData(String step, WebElement element, String data) {
        try {
            waitVisibility(element);
            element.clear();
            element.sendKeys(data);
        }catch (WebDriverException e){
            fail("Element is not visible");
        }
    }

    //----------------------------------------------SELECTIONS----------------------------------------------------------

    @Step("{step}")
    public void selectEmptyItemAtDropList(String step, WebElement listName) {
        Select emptyItem = new Select(listName);
        emptyItem.selectByIndex(0);
    }

    @Step("{step}")
    public void selectItemByIndex(String step, WebElement element, int index) {
        Select input = new Select(element);
        input.selectByIndex(index);
    }

    @Step("{step}")
    public void selectSpecificValueInDropDown(String step, WebElement element, String specificValue) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(specificValue);
    }


    @Step("{step}")
    public void selectRandomValueInDropDown(String step, WebElement element) {
        Select selectElement = new Select(element);
        List<WebElement> validSelectOptions = selectElement
                .getOptions()
                .stream()
                .filter(p -> !p.getAttribute("value").equals(""))
                .collect(Collectors.toList());
        Random rand = new Random();
        WebElement chosenElement = validSelectOptions.get(rand.nextInt(validSelectOptions.size()));
        selectElement.selectByValue(chosenElement.getAttribute("value"));
    }

    //------------------------------------------------CLICKS------------------------------------------------------------

    @Step("{step}")
    public void waitAndClick(String step, WebElement element) {
        try {
            waitVisibility(element);
            waitClickability(element);
            element.click();
        } catch (StaleElementReferenceException ex) {
            element.click();
        } catch (WebDriverException wb) {
            element.click();
        }
    }


    @Step("{step}")
    public void waitAndMoveAndClick(String step, WebElement element) {
        try {
            org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(element);
            actions.perform();
            waitVisibility(element);
            waitClickability(element);
            actions.moveToElement(element);
            actions.perform();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("Try : " + step);
            element.click();
        } catch (StaleElementReferenceException ex) {
            org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(element);
            actions.perform();
            element.click();
        }
    }

    @Step("{step}")
    public void clickDirectly(String step, WebElement element){
        waitVisibility(element);
        waitClickability(element);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Step("{step}")
    public void waitAndClickOrSkipIfNoElement(String step, WebElement element) {
        try {
            waitVisibility(element);
            waitClickability(element);
            element.click();
        } catch (StaleElementReferenceException ex) {
            element.click();
        } catch (WebDriverException wb) {
            return;
        }
    }


    //-------------------------------------------MOUSE MOVEMENTS--------------------------------------------------------

    @Step("{step}")
    public void moveToElement(String step, WebElement element) {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    @Step("{step}")
    public void swipeRight(String step, WebElement element) {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.dragAndDropBy(element, 250, 0);
        actions.perform();
    }

    //------------------------------------------------HELPERS-----------------------------------------------------------

    public List<WebElement> makeListOfElements(By locator){
        return driver.findElements(locator);
    }

    @Step("Get Games Amount")
    public int getGamesAmount(By locator) {
        return makeListOfElements(locator).size();
    }
}
