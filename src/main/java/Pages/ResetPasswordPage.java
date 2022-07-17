package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.format.ResolverStyle;

public class ResetPasswordPage {
    WebDriver driver;

    public ResetPasswordPage (WebDriver driver) {this.driver = driver;}

    By resetPasswordLink = By.className("pull-left");
    By pageTitle = By.className("title");
    By emailAddressField = By.id("email");
    By emptyEmailAddressError = By.className("text-danger");
    By confirmationPopup = By.className("swal2-popup");
    By confirmationButton = By.className("swal2-confirm");
    By cancelButton = By.className("swal2-cancel");
    By resetPasswordButton = By.className("ng-tns-c413-1");
    By invalidEmailError = By.className("swal2-icon-error");

    @Step("Navigate to the reset password page")
    public ResetPasswordPage OpenResetPasswordPage () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordLink));
        driver.findElement(resetPasswordLink).click();
        return this;
    }
    @Step("Check reset password page")
    public ResetPasswordPage CheckResetPasswordPage () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        String ResetPasswordPageTitle = driver.findElement(pageTitle).getText();
        Assert.assertTrue(ResetPasswordPageTitle.contains("Reset password"));
        return this;
    }
    @Step("Enter email address")
    public ResetPasswordPage EnterEmailAddress (String emailAddress) throws InterruptedException {
        driver.findElement(emailAddressField).sendKeys(emailAddress);
        return this;
    }
    @Step("Check entered email address")
    public ResetPasswordPage CheckEnteredEmailAddress (String emailAddress) throws InterruptedException {
        String CheckEmailAddres = driver.findElement(emailAddressField).getAttribute("value");
        Assert.assertEquals(CheckEmailAddres, emailAddress);
        return this;
    }
    @Step("Click Reset button")
    public ResetPasswordPage ClickResetButton () throws InterruptedException {
        driver.findElement(resetPasswordButton).click();
        return this;
    }
    @Step("Check confirmation popup")
    public ResetPasswordPage CheckConfirmationPopup () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationPopup));
        Assert.assertTrue(driver.findElement(confirmationButton).isDisplayed());
        return this;
    }
    @Step("Click on the confirm button")
    public ResetPasswordPage ClickConfirmButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationButton));
        driver.findElement(confirmationButton).click();
        return this;
    }
    @Step("Close confirmation popup")
    public ResetPasswordPage CloseConfirmationPopup () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));
        driver.findElement(cancelButton).click();
        return this;
    }
    @Step("Check invalid email Error")
    public ResetPasswordPage InvalidEmailError() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailError));
//        String InvalidEmailAddressError = driver.findElement(invalidEmailError).getAttribute("value");
//        Assert.assertTrue(InvalidEmailAddressError.contains("Error"));
        Assert.assertTrue(driver.findElement(invalidEmailError).isDisplayed());
        return this;
    }
}

