package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Assertions extends BaseClass {
    public Assertions(WebDriver driver) {
        super(driver);
    }

    @Step("{step}")
    public void assertURL(String step, String expectedURL) {
        try {
            assertTrue(wait.until(ExpectedConditions.urlToBe(expectedURL)));
        }catch (TimeoutException e){
            fail("Url is not correct: " + driver.getCurrentUrl());
        }
    }


    @Step("{step}")
    public void containsURL(String step, String expectedURL) {
        try {
            assertTrue(wait.until(ExpectedConditions.urlContains(expectedURL)));
        }catch (TimeoutException e){
            fail("Url is not correct: " + driver.getCurrentUrl());
        }
    }

    //------------------------------------------------TEXT--------------------------------------------------------------

    @Step("{step}")
    public void assertTextPresentAtPage(String step, String text) {
        try {
            assertTrue(wait.until(new ExpectedCondition<Boolean>() {
                @Nullable
                @Override
                public Boolean apply(@Nullable WebDriver driver) {
                    return driver.getPageSource().contains(text);
                }
            }));
        }catch (TimeoutException e){
            fail("Text not present at page");
        }
    }


    @Step("{step}")
    public void assertTextAbsentAtPage(String step, String text) {
        try {
            assertFalse(wait.until(new ExpectedCondition<Boolean>() {
                @Nullable
                @Override
                public Boolean apply(@Nullable WebDriver driver) {
                    return driver.getPageSource().contains(text);
                }
            }));
        }catch (TimeoutException e){
            fail("Text not absent at page");
        }
    }

    @Step("{step}")
    public void containTextFromElement(String step, WebElement element, String expectedText) {
        try {
            assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText)));
        }catch (TimeoutException e){
            fail("Text not present in element");
        }
    }

    @Step("{step}")
    public void textNotEquals(String step, String text1, String text2){
        assertFalse(text1.equals(text2));
    }


    //----------------------------------------------ELEMENTS------------------------------------------------------------

    @Step("{step}")
    public void assertElementPresent(String step, WebElement element) {
        try {
            assertTrue(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed());
        }catch (TimeoutException e){
            fail("Element not found");
        }
    }

    @Step("{step}")
    public void assertElementPresentInDom(String step, By locator) {
        try {
            assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isEnabled());
        }catch (TimeoutException e){
            fail("Element not found");
        }
    }

    @Step("{step}")
    public void assertElementIsNotPresent(String step, By locator) {
        try {
            assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)));
        }catch (TimeoutException e){
            fail("Element is found");
        }
    }

    @Step("{step}")
    public void assertElementIsNotVisible(String step, WebElement element) {
        try {
            assertTrue(wait.until(ExpectedConditions.invisibilityOf(element)));
        }catch (TimeoutException e){
            fail("Element is found");
        }
    }



    //-----------------------------------------------TITLE--------------------------------------------------------------

    @Step("{step}")
    public void assertPageTitle(String step, String text) {
        try {
            assertTrue(wait.until(ExpectedConditions.titleIs(text)));
        }catch (TimeoutException e){
            fail("Title is not correct");
        }
    }

    //----------------------------------------------COUNTERS------------------------------------------------------------


    @Step("Amount is increased")
    public void amountIsIncreased(int amountOfElementsBefore, int amountOfElementsAfter) {
        if (amountOfElementsBefore >= amountOfElementsAfter) {
            fail("Amount wasn't increased");
        }
    }


    @Step("{step}")
    public void countNumberOfWebElements(String step, List<WebElement> elementsList, int requiredNumber) {
        int amount = elementsList.size();
        if (amount == requiredNumber) {
            System.out.println("Items on page are equal = " + requiredNumber);
        } else {
            fail("FAIL: Number of elements on the page" + amount);
            System.out.println("FAIL: Items on the page do not match the desired value = " + requiredNumber);
            System.out.println("FAIL: Number of elements on the page" + amount);
        }
    }


    @Step("{step}")
    public void assertOneOfElementsIsPresent(String step, WebElement... elements) {
        List<WebElement> webElementList = new ArrayList<>(Arrays.asList(elements));
        boolean result = true;
        for (WebElement element : webElementList) {
            try {
                assertTrue(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed());
                result = true;
                break;
            }
            catch (TimeoutException e) {
                result = false;
                System.out.println("Element wasn't found");
                continue;
            }
        }
        if (!result) {
            fail("No elements were found");
        }
    }


    //----------------------------------------------CSS ASSERTIONS------------------------------------------------------------

    @Step("{step}")
    public void assertFontSizeIsCorrect(String step, WebElement element, String size){
        assertEquals(element.getCssValue("font-size"), size);
    }
}


