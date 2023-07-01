import com.mifmif.common.regex.Generex;
import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testsInfo.Data;
import testsInfo.Urls;

@Listeners(TestListenerAdapter.class)
@Epic("Mobile")
@Feature("Registration")
public class RegistrationTests extends BaseTest {

    @Parameters("url")
    @Step("Successful registration")
    @Test(description = "Successful registration")
    @Description("Successful registration can be done")
    public void registrationT1MobileTest(String url) {
        goToWebPage("Go to UK page", url + Urls.UK_IP);
        actions.waitAndClick("Click on Join button",header.getRegistrationButton());
        assertions.assertElementPresent("Registration widget is open", registrationForm.getEmailField());
        actions.inputData("Add email", registrationForm.getEmailField(), new Generex(Data.regexEmailForRegistration).random());
        actions.inputData("Add login", registrationForm.getLoginField(), new Generex(Data.regexLoginAndPasswordForRegistration).random());
        actions.inputData("Add password", registrationForm.getPasswordField(), new Generex(Data.regexLoginAndPasswordForRegistration).random());
        sleep(5000);
        actions.waitAndClick("Click Next button", registrationForm.getNextButton());
        assertions.assertElementPresent("Moved to step 2 successfully", registrationForm.getOpenAccountButton());
        assertions.assertElementPresent("Step 2 fields are available", registrationForm.getFirstNameField());
        sleep(5000);
        actions.inputData("Add First Name", registrationForm.getFirstNameField(), Data.FIRST_NAME);
        actions.inputData("Add Last Name", registrationForm.getLastNameField(), Data.LAST_NAME);
        actions.selectItemByIndex("Select birthday day", registrationForm.getBirthdayDayField(), 1);
        actions.selectItemByIndex("Select birthday month", registrationForm.getBirthdayMonthField(), 1);
        actions.selectItemByIndex("Select birthday year", registrationForm.getBirthdayYearField(), 1);
        actions.inputData("Add Address", registrationForm.getAddressField(), Data.ADDRESS);
        actions.inputData("Add City", registrationForm.getCityField(), Data.CITY);
        actions.inputData("Add Postcode", registrationForm.getZipCodeField(), Data.POSTCODE);
        actions.inputData("Add mobile number", registrationForm.getCellPhoneField(), Data.PHONE_NUMBER);
        actions.waitAndClick("Accept Special Bonus", registrationForm.getTermsCheckbox());
        actions.waitAndClick("Accept Terms", registrationForm.getTermsCheckbox());
        actions.waitAndClick("Click Open Account", registrationForm.getOpenAccountButton());
        assertions.assertOneOfElementsIsPresent("Successful registration banner is shown", header.getDepositButton(), regilyWidgets.getRotateYourDeviceMessage());
        assertions.assertURL("URL is correct", url + Urls.UK_IP);
    }
}
