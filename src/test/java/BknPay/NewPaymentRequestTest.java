package BknPay;

import CommonSteps.CommonSteps;
import Pages.NewPaymentRequestPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static DataObject.NewPaymentRequestData.*;
import static DataObject.LoginData.*;

public class NewPaymentRequestTest {
    WebDriver driver;
    NewPaymentRequestPage newPaymentRequestPage;
    CommonSteps commonSteps;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://staging-identity301pay.bkn301.sm/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dsubmerchant-ui2%26redirect_uri%3Dhttps%253A%252F%252Fstaging-dashboard301pay.bkn301.sm%252FloginCallback%26response_type%3Dcode%26scope%3Dopenid%2520submerchants_api%2520email%26nonce%3D58bb17cb44562eb82b5d7f08b956e8dcdaStYg4BL%26state%3Df4419052e282c9fd6f5787a43b9578baa5jf38IGB%26code_challenge%3D8_xpQCBw5KKMRyRYO_JE9LXABzNM0OiyaN9fOqOrMLw%26code_challenge_method%3DS256");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void ValidNewPaymentRequestTest() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        newPaymentRequestPage = new NewPaymentRequestPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        newPaymentRequestPage.CheckNewPaymentRequestButton();
        newPaymentRequestPage.ClickNewPaymentRequestButton();
        newPaymentRequestPage.CheckNewPaymentRequestPage();
        newPaymentRequestPage.ChooseEmailOption();
        newPaymentRequestPage.EnterAmount(validAmount);
        newPaymentRequestPage.EnterReference(referenceData);
        newPaymentRequestPage.EnterFullName(validFullName);
        newPaymentRequestPage.EnterEmailAddress(validEmailAddress);
        newPaymentRequestPage.ClickSendMoneyRequestButton();
        newPaymentRequestPage.CheckValidPaymentStatus();
        newPaymentRequestPage.CheckAmountDetails(validAmount);
        newPaymentRequestPage.CheckReferenceDetails(referenceData);
        newPaymentRequestPage.CheckNameDetails(validFullName);
        newPaymentRequestPage.CheckEmailDetails(validEmailAddress);
        newPaymentRequestPage.CheckPaymentHistory();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void NewPaymentRequestWithoutReference() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        newPaymentRequestPage = new NewPaymentRequestPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        newPaymentRequestPage.CheckNewPaymentRequestButton();
        newPaymentRequestPage.ClickNewPaymentRequestButton();
        newPaymentRequestPage.CheckNewPaymentRequestPage();
        newPaymentRequestPage.ChooseEmailOption();
        newPaymentRequestPage.EnterAmount(validAmount);
        newPaymentRequestPage.EnterFullName(validFullName);
        newPaymentRequestPage.EnterEmailAddress(validEmailAddress);
        newPaymentRequestPage.ClickSendMoneyRequestButton();
        newPaymentRequestPage.CheckEmptyFieldError();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void NewPaymentRequestWithoutEmail () throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        newPaymentRequestPage = new NewPaymentRequestPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        newPaymentRequestPage.CheckNewPaymentRequestButton();
        newPaymentRequestPage.ClickNewPaymentRequestButton();
        newPaymentRequestPage.CheckNewPaymentRequestPage();
        newPaymentRequestPage.ChooseEmailOption();
        newPaymentRequestPage.EnterAmount(validAmount);
        newPaymentRequestPage.EnterFullName(validFullName);
        newPaymentRequestPage.ClickSendMoneyRequestButton();
        newPaymentRequestPage.CheckEmptyFieldError();
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void NewPaymentRequestWithPhone() throws InterruptedException{
        commonSteps = new CommonSteps(driver);
        newPaymentRequestPage = new NewPaymentRequestPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        newPaymentRequestPage.CheckNewPaymentRequestButton();
        newPaymentRequestPage.ClickNewPaymentRequestButton();
        newPaymentRequestPage.CheckNewPaymentRequestPage();
        newPaymentRequestPage.ChoosePhoneOption();
        newPaymentRequestPage.EnterAmount(validAmount);
        newPaymentRequestPage.EnterReference(referenceData);
        newPaymentRequestPage.EnterFullName(validFullName);
        newPaymentRequestPage.EnterPhoneNumber(validPhoneNumber);
        newPaymentRequestPage.ClickSendMoneyRequestButton();
        newPaymentRequestPage.CheckValidPaymentStatus();
        newPaymentRequestPage.CheckPhoneNumberDetails(validPhoneNumber);
        newPaymentRequestPage.CheckReferenceDetails(referenceData);
        newPaymentRequestPage.CheckNameDetails(validFullName);
        newPaymentRequestPage.CheckAmountDetails(validAmount);
        newPaymentRequestPage.CheckPaymentHistory();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
