package BknPay;

import CommonSteps.CommonSteps;
import Pages.EditCompanyInfoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;
import static DataObject.LoginData.*;
import static DataObject.EditCompanyInfoData.*;

public class EditCompanyInfoTest {

    WebDriver driver;
    EditCompanyInfoPage editCompanyInfoPage;
    CommonSteps commonSteps;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://staging-identity301pay.bkn301.sm/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dsubmerchant-ui2%26redirect_uri%3Dhttps%253A%252F%252Fstaging-dashboard301pay.bkn301.sm%252FloginCallback%26response_type%3Dcode%26scope%3Dopenid%2520submerchants_api%2520email%26nonce%3D58bb17cb44562eb82b5d7f08b956e8dcdaStYg4BL%26state%3Df4419052e282c9fd6f5787a43b9578baa5jf38IGB%26code_challenge%3D8_xpQCBw5KKMRyRYO_JE9LXABzNM0OiyaN9fOqOrMLw%26code_challenge_method%3DS256");
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void ValidEditCompanyName () throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        editCompanyInfoPage = new EditCompanyInfoPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        editCompanyInfoPage.CheckSettingsOverviewButton();
        editCompanyInfoPage.ClickSettingsOverviewButton();
        editCompanyInfoPage.CheckEditCompanyInfoButton();
        editCompanyInfoPage.ClickEditCompanyInfoButton();
        editCompanyInfoPage.CheckEditCompanyInfoPage();
        editCompanyInfoPage.CheckCompanyNameField();
        editCompanyInfoPage.EnterCompanyName(validCompanyName);
        editCompanyInfoPage.CheckSaveButton();
        editCompanyInfoPage.ClickSaveButton();
        editCompanyInfoPage.CheckSuccessMessage();
        editCompanyInfoPage.CheckSavedCompanyName(validCompanyName);
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void ValidEditRepresentative () throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        editCompanyInfoPage = new EditCompanyInfoPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        editCompanyInfoPage.CheckSettingsOverviewButton();
        editCompanyInfoPage.ClickSettingsOverviewButton();
        editCompanyInfoPage.CheckEditCompanyInfoButton();
        editCompanyInfoPage.ClickEditCompanyInfoButton();
        editCompanyInfoPage.CheckEditCompanyInfoPage();
        editCompanyInfoPage.CheckRepresentativeField();
        editCompanyInfoPage.EnterRepresentative(validRepresentative);
        editCompanyInfoPage.CheckSaveButton();
        editCompanyInfoPage.ClickSaveButton();
        editCompanyInfoPage.CheckSavedRepresentative(validRepresentative);
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void ValidEmailEdit () throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        editCompanyInfoPage = new EditCompanyInfoPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        editCompanyInfoPage.CheckSettingsOverviewButton();
        editCompanyInfoPage.ClickSettingsOverviewButton();
        editCompanyInfoPage.CheckEditCompanyInfoButton();
        editCompanyInfoPage.ClickEditCompanyInfoButton();
        editCompanyInfoPage.CheckEditCompanyInfoPage();
        editCompanyInfoPage.CheckRepresentativeEmailField();
        editCompanyInfoPage.EnterRepresentativeEmail(validRepresentativeEmail);
        editCompanyInfoPage.CheckSaveButton();
        editCompanyInfoPage.ClickSaveButton();
        editCompanyInfoPage.CheckSavedRepresentativeEmail(validRepresentativeEmail);
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void ValidPhoneNumberEdit () throws InterruptedException {
    commonSteps = new CommonSteps(driver);
    editCompanyInfoPage = new EditCompanyInfoPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        editCompanyInfoPage.CheckSettingsOverviewButton();
        editCompanyInfoPage.ClickSettingsOverviewButton();
        editCompanyInfoPage.CheckEditCompanyInfoButton();
        editCompanyInfoPage.ClickEditCompanyInfoButton();
        editCompanyInfoPage.CheckEditCompanyInfoPage();
        editCompanyInfoPage.CheckPhoneNumberField();
        editCompanyInfoPage.EnterPhoneNumber(validPhoneNumber);
        editCompanyInfoPage.CheckSaveButton();
        editCompanyInfoPage.ClickSaveButton();
        editCompanyInfoPage.CheckSavedPhoneNumber(validPhoneNumber);
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void InvalidPhoneEdit () throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        editCompanyInfoPage = new EditCompanyInfoPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        editCompanyInfoPage.CheckSettingsOverviewButton();
        editCompanyInfoPage.ClickSettingsOverviewButton();
        editCompanyInfoPage.CheckEditCompanyInfoButton();
        editCompanyInfoPage.ClickEditCompanyInfoButton();
        editCompanyInfoPage.CheckEditCompanyInfoPage();
        editCompanyInfoPage.CheckPhoneNumberField();
        editCompanyInfoPage.EnterPhoneNumber(invalidPhoneNumber);
        editCompanyInfoPage.CheckInvalidFormatNumberError();
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void InvalidEmailEdit () throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        editCompanyInfoPage = new EditCompanyInfoPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        editCompanyInfoPage.CheckSettingsOverviewButton();
        editCompanyInfoPage.ClickSettingsOverviewButton();
        editCompanyInfoPage.CheckEditCompanyInfoButton();
        editCompanyInfoPage.ClickEditCompanyInfoButton();
        editCompanyInfoPage.CheckEditCompanyInfoPage();
        editCompanyInfoPage.CheckRepresentativeEmailField();
        editCompanyInfoPage.EnterRepresentativeEmail(invalidRepresentativeEmail);
        editCompanyInfoPage.CheckInvalidEmailError();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
