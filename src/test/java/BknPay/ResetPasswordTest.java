package BknPay;

import Pages.ResetPasswordPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static DataObject.ResetPasswordData.*;

public class ResetPasswordTest {
    WebDriver driver;
    ResetPasswordPage resetPasswordPage;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://staging-identity301pay.bkn301.sm/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dsubmerchant-ui2%26redirect_uri%3Dhttps%253A%252F%252Fstaging-dashboard301pay.bkn301.sm%252FloginCallback%26response_type%3Dcode%26scope%3Dopenid%2520submerchants_api%2520email%26nonce%3D58bb17cb44562eb82b5d7f08b956e8dcdaStYg4BL%26state%3Df4419052e282c9fd6f5787a43b9578baa5jf38IGB%26code_challenge%3D8_xpQCBw5KKMRyRYO_JE9LXABzNM0OiyaN9fOqOrMLw%26code_challenge_method%3DS256");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void ValidPasswordResetTest() throws InterruptedException {
        resetPasswordPage = new ResetPasswordPage(driver);
        resetPasswordPage.OpenResetPasswordPage();
        resetPasswordPage.CheckResetPasswordPage();
        resetPasswordPage.EnterEmailAddress(validEmailAddress);
        resetPasswordPage.CheckEnteredEmailAddress(validEmailAddress);
        resetPasswordPage.ClickResetButton();
        resetPasswordPage.CheckConfirmationPopup();
    }
    @Test
    public void InvalidEmailPasswordReset() throws InterruptedException {
        resetPasswordPage = new ResetPasswordPage(driver);
        resetPasswordPage.OpenResetPasswordPage();
        resetPasswordPage.CheckResetPasswordPage();
        resetPasswordPage.EnterEmailAddress(invalidEmailAddress);
        resetPasswordPage.CheckEnteredEmailAddress(invalidEmailAddress);
        resetPasswordPage.ClickResetButton();
        resetPasswordPage.CheckConfirmationPopup();
        resetPasswordPage.ClickConfirmButton();
        resetPasswordPage.InvalidEmailError();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}