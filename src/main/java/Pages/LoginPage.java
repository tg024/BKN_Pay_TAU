package Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static DataObject.LoginData.*;
import DataObject.LoginData.*;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By validationError = By.className("validation-summary-errors");

    @Step ("Check invalid email address error")
    public LoginPage CheckInvalidEmailOrPasswordError () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validationError));
        String InvalidEmailError = driver.findElement(validationError).getText();
        Assert.assertTrue(InvalidEmailError.contains("Invalid username or password"));
        return this;
    }
    @Step("Check empty email address field error")
    public LoginPage CheckEmptyEmailError() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validationError));
        String EmptyEmailError = driver.findElement(validationError).getText();
        Assert.assertTrue(EmptyEmailError.contains("The Email field is required."));
        return this;
    }
    @Step("Check empty password field error")
    public LoginPage CheckEmptyPasswordError() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validationError));
        String EmptyPasswordError = driver.findElement(validationError).getText();
        Assert.assertTrue(EmptyPasswordError.contains("The Password field is required."));
        return this;
    }
}
