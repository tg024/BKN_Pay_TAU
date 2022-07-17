package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class NewPaymentLinkPage {
    WebDriver driver;

    public NewPaymentLinkPage (WebDriver driver) {this.driver = driver;}

    By pageTitle = By.className("fs-28");
    By newPaymentLinkButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ng-component/div/nb-card[1]/nb-card-header/div/div[2]/button[2]");
    By amountField = By.className("ant-input-number-input");
    By referenceField = By.id("reference");
    By sendMoneyRequestButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/ngx-payment-link-new-form/nz-spin/div/div/div/form/div[2]/div/nz-form-item/nz-form-control/div/div/button[2]");
    By invalidCredentialError = By.className("swal2-title");
    By zeroAmountError = By.className("text-danger");
    By emptyFieldError = By.className("text-danger");

    @Step ("Check if New Payment Link button is displayed")
    public NewPaymentLinkPage CheckNewPaymentLinkButton () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPaymentLinkButton));
        return this;
    }
    @Step ("Click on the New Payment Link button")
    public NewPaymentLinkPage ClickNewPaymentLinkButton () {
        driver.findElement(newPaymentLinkButton).click();
        return this;
    }
    @Step ("Check if New Payment Link page is displayed")
    public NewPaymentLinkPage CheckNewPaymentLinkPage () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        Assert.assertTrue(driver.findElement(pageTitle).isDisplayed());
        return this;
    }
    @Step ("Check if Amount field is displayed")
    public NewPaymentLinkPage CheckAmountField () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        Assert.assertTrue(driver.findElement(amountField).isDisplayed());
        return this;
    }
    @Step ("Enter Amount")
    public NewPaymentLinkPage EnterAmount (String amount) {
        driver.findElement(amountField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(amountField).sendKeys(amount);
        String AmountValue = driver.findElement(amountField).getAttribute("value");
        Assert.assertEquals(AmountValue, amount);
        return this;
    }
    @Step ("Check if Reference field is displayed")
    public NewPaymentLinkPage CheckReferenceField () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(referenceField));
        Assert.assertTrue(driver.findElement(referenceField).isDisplayed());
        return this;
    }
    @Step ("Enter Reference")
    public NewPaymentLinkPage EnterReference (String reference) {
        driver.findElement(referenceField).sendKeys(reference);
        String ReferenceValue = driver.findElement(referenceField).getAttribute("value");
        Assert.assertEquals(ReferenceValue, reference);
        return this;
    }
    @Step ("Check if send money request button is displayed")
    public NewPaymentLinkPage CheckSendMoneyRequestButton () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendMoneyRequestButton));
        Assert.assertTrue(driver.findElement(sendMoneyRequestButton).isDisplayed());
        return this;
    }
    @Step ("Click on the Send money request button")
    public NewPaymentLinkPage ClickSendMoneyRequestButton () {
        driver.findElement(sendMoneyRequestButton).click();
        return this;
    }
    @Step ("Check invalid credential error message")
    public NewPaymentLinkPage CheckInvalidCredentialError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialError));
        String EmptyFieldErrorValue = driver.findElement(invalidCredentialError).getText();
        Assert.assertTrue(EmptyFieldErrorValue.contains("Fill in the required fields"));
        return this;
    }
    @Step ("Check error message when amount is 0")
    public NewPaymentLinkPage CheckZeroAmountError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zeroAmountError));
        String ZeroAmountErrorValue = driver.findElement(zeroAmountError).getText();
        Assert.assertTrue(ZeroAmountErrorValue.contains("This field value is not correct"));
        return this;
    }
    @Step ("Clear Amount field")
    public NewPaymentLinkPage ClearAmountField () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        driver.findElement(amountField).sendKeys(Keys.BACK_SPACE);
        return this;
    }
    @Step ("Check empty field error")
    public NewPaymentLinkPage CheckEmptyFieldError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyFieldError));
        String EmptyFieldErrorValue = driver.findElement(emptyFieldError).getText();
        Assert.assertTrue(EmptyFieldErrorValue.contains("This field is required"));
        return this;
    }
}
