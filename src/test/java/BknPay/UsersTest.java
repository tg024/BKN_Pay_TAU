package BknPay;

import CommonSteps.CommonSteps;
import Pages.UsersPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static DataObject.LoginData.*;
import static DataObject.UsersData.*;

public class UsersTest {
    WebDriver driver;
    CommonSteps commonSteps;
    UsersPage usersPage;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://staging-identity301pay.bkn301.sm/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dsubmerchant-ui2%26redirect_uri%3Dhttps%253A%252F%252Fstaging-dashboard301pay.bkn301.sm%252FloginCallback%26response_type%3Dcode%26scope%3Dopenid%2520submerchants_api%2520email%26nonce%3D58bb17cb44562eb82b5d7f08b956e8dcdaStYg4BL%26state%3Df4419052e282c9fd6f5787a43b9578baa5jf38IGB%26code_challenge%3D8_xpQCBw5KKMRyRYO_JE9LXABzNM0OiyaN9fOqOrMLw%26code_challenge_method%3DS256");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void ValidSearchUser() throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        usersPage = new UsersPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        commonSteps.ClickUsersButton();
        usersPage.CheckPageTitle();
        usersPage.EnterUserName(validUserName);
        usersPage.CheckFoundedUser(validUserName);
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void InvalidSearchUser () throws InterruptedException {
        commonSteps = new CommonSteps(driver);
        usersPage = new UsersPage(driver);
        commonSteps.EnterEmail(emailAddress);
        commonSteps.CheckEnteredEmail(emailAddress);
        commonSteps.EnterPassword(password);
        commonSteps.CheckEnteredPassword(password);
        commonSteps.ClickLoginButton();
        commonSteps.CheckValidLogin();
        commonSteps.ChooseEnglishLanguage();
        commonSteps.CheckSettingsButton();
        commonSteps.ClickSettingsButton();
        commonSteps.ClickUsersButton();
        usersPage.CheckPageTitle();
        usersPage.EnterUserName(invalidUserName);
        usersPage.CheckUserNotFoundError();
    }
    @AfterMethod
    public void teardown() {driver.quit();}
}
