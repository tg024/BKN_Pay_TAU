package BknPay;

import Pages.LoginPage;
import CommonSteps.CommonSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static DataObject.LoginData.*;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    CommonSteps commonSteps;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://staging-identity301pay.bkn301.sm/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dsubmerchant-ui2%26redirect_uri%3Dhttps%253A%252F%252Fstaging-dashboard301pay.bkn301.sm%252FloginCallback%26response_type%3Dcode%26scope%3Dopenid%2520submerchants_api%2520email%26nonce%3D58bb17cb44562eb82b5d7f08b956e8dcdaStYg4BL%26state%3Df4419052e282c9fd6f5787a43b9578baa5jf38IGB%26code_challenge%3D8_xpQCBw5KKMRyRYO_JE9LXABzNM0OiyaN9fOqOrMLw%26code_challenge_method%3DS256");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void ValidLoginTest() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        loginPage = new LoginPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void InvalidEmailLogin() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        loginPage = new LoginPage(driver);
        commonSteps.EnterEmail(invalidEmail);
        commonSteps.CheckEnteredEmail(invalidEmail);
        commonSteps.EnterPassword(invalidPassword);
        commonSteps.CheckEnteredPassword(invalidPassword);
        commonSteps.ClickLoginButton();
        loginPage.CheckInvalidEmailOrPasswordError();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void InvalidPasswordLogin() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        loginPage = new LoginPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(invalidPassword);
        commonSteps.CheckEnteredPassword(invalidPassword);
        commonSteps.ClickLoginButton();
        loginPage.CheckInvalidEmailOrPasswordError();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void EmptyEmailLogin() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        loginPage = new LoginPage(driver);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        loginPage.CheckEmptyEmailError();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void EmptyPasswordLogin() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        loginPage = new LoginPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.ClickLoginButton();
        loginPage.CheckEmptyPasswordError();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void EmptyFieldsLogin() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        loginPage = new LoginPage(driver);
        commonSteps.ClickLoginButton();
        loginPage.CheckEmptyEmailError();
        loginPage.CheckEmptyPasswordError();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}