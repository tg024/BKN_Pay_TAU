package CommonSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static DataObject.LoginData.*;
import DataObject.LoginData.*;

public class CommonSteps {
    WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;}

        By emailAddressField = By.id("Email");
        By passwordField = By.id("Password");
        By loginButton = By.id("btn-login");
        By profileButton = By.className("user-picture");
        By settingsButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/nb-sidebar/div/div/nb-menu/ul/li[4]/a/span");

    @Step ("Fill email address field")
    public  CommonSteps EnterEmail (String emailAddress) throws InterruptedException {
        driver.findElement(emailAddressField).sendKeys(emailAddress);
        return this;
    }
    @Step ("Check entered email")
    public CommonSteps CheckEnteredEmail (String emailAddress) {
        String EmailInputValue = driver.findElement(emailAddressField).getAttribute("value");
//        System.out.printf(CheckEmail + "++++++++++++++");
        Assert.assertEquals(EmailInputValue, emailAddress);
        return this;
    }
    @Step("Enter password")
    public CommonSteps EnterPassword(String password) throws InterruptedException {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step("Check entered password")
    public CommonSteps CheckEnteredPassword(String password) throws InterruptedException{
        String PasswordValue = driver.findElement(passwordField).getAttribute("value");
        Assert.assertEquals(PasswordValue, password);
        return this;
    }
    @Step("Click on the login button")
    public CommonSteps ClickLoginButton () throws InterruptedException {
        driver.findElement(loginButton).click();
        return this;
    }
    @Step ("Check login validation")
    public CommonSteps CheckValidLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        Assert.assertTrue(driver.findElement(profileButton).isDisplayed());
        return this;
    }
    @Step ("Check if Settings button is displayed ")
    public CommonSteps CheckSettingsButton () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsButton));
        Assert.assertTrue(driver.findElement(settingsButton).isDisplayed());
        return this;
    }
    @Step ("Click on the Settings button")
    public CommonSteps ClickSettingsButton () {
        driver.findElement(settingsButton).click();
        return this;
    }
}
