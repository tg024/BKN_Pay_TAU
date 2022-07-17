package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewPaymentRequestPage {
    WebDriver driver;

    public NewPaymentRequestPage(WebDriver driver) {this.driver = driver;}

    By newPaymentRequestButton = By.className("ant-btn");
    By newPaymentRequestPage = By.className("fs-28");
    By emailRadioButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/nz-spin/div/div/div/form/nz-form-item[1]/nz-form-control/div/div/nz-radio-group/label[1]/span[1]");
    By phoneRadioButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/nz-spin/div/div/div/form/nz-form-item[1]/nz-form-control/div/div/nz-radio-group/label[2]/span[1]/input");
    By amountField = By.className("ant-input-number-input");
    By referenceField = By.id("reference");
    By fullNameField = By.id("customerFullname");
    By emailAddressField = By.id("customerEmailAddress");
    By phoneNumberField = By.id("customerMobileNumber");
    By sendMoneyRequestButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/nz-spin/div/div/div/form/div[2]/div/nz-form-item/nz-form-control/div/div/button[2]");
    By paymentStatus = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/div/div[1]/h4");
    By amountDetail = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/div/div[2]/div[1]/div/div/div[2]");
    By referenceDetail = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/div/div[2]/div[2]/div/div/div");
    By nameDetail = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/div/div[2]/div[3]/div/div[1]/div[2]");
    By emailDetail = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/div/div[2]/div[3]/div/div[2]/div[2]");
    By phoneNumberDetail = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/div/div[2]/div[3]/div/div[2]/div[2]");
    By paymentHistory = By.className("col-11");
    By invalidCredentialError = By.className("swal2-title");

    @Step("Check if new payment request button is displayed")
    public NewPaymentRequestPage CheckNewPaymentRequestButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPaymentRequestButton));
        Assert.assertTrue(driver.findElement(newPaymentRequestButton).isDisplayed());
        return this;
    }
    @Step("Navigate to the new payment request page")
    public NewPaymentRequestPage ClickNewPaymentRequestButton() {
        driver.findElement(newPaymentRequestButton).click();
        return this;
    }
    @Step("Check if new payment request page is displayed")
    public NewPaymentRequestPage CheckNewPaymentRequestPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPaymentRequestPage));
        String PageTitle = driver.findElement(newPaymentRequestPage).getText();
        Assert.assertTrue(PageTitle.contains("New payment request"));
        return this;
    }
    @Step("Choose Email in the contact by section")
    public NewPaymentRequestPage ChooseEmailOption() {
        WebElement radioElement = driver.findElement(emailRadioButton);
        boolean selectState = radioElement.isSelected();
        if(!selectState){
            radioElement.click();
            Assert.assertTrue(radioElement.isEnabled());
        }
        return this;
    }
    @Step("Choose Phone in the contact by section")
    public NewPaymentRequestPage ChoosePhoneOption() {
        WebElement radioElement = driver.findElement(phoneRadioButton);
        boolean selectState = radioElement.isSelected();
        if(!selectState){
            radioElement.click();
        }
        return this;
    }
    @Step("Enter valid amount")
    public NewPaymentRequestPage EnterAmount(String amount) {
        driver.findElement(amountField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(amountField).sendKeys(amount);
        String AmountValue = driver.findElement(amountField).getAttribute("value");
        Assert.assertEquals(AmountValue, amount);
        return this;
    }
    @Step("Enter reference")
    public NewPaymentRequestPage EnterReference(String reference) {
        driver.findElement(referenceField).sendKeys(reference);
        String ReferenceValue = driver.findElement(referenceField).getAttribute("value");
        Assert.assertEquals(ReferenceValue, reference);
        return this;
    }
    @Step("Enter full name")
    public NewPaymentRequestPage EnterFullName(String fullName) {
        driver.findElement(fullNameField).sendKeys(fullName);
        String FullNameValue = driver.findElement(fullNameField).getAttribute("value");
        Assert.assertEquals(FullNameValue, fullName);
        return this;
    }
    @Step("Enter email address")
    public NewPaymentRequestPage EnterEmailAddress(String emailAddress) {
        driver.findElement(emailAddressField).sendKeys(emailAddress);
        String EmailAddressValue = driver.findElement(emailAddressField).getAttribute("value");
        Assert.assertEquals(EmailAddressValue, emailAddress);
        return this;
    }
    @Step
    public NewPaymentRequestPage EnterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        String PhoneNumberValue = driver.findElement(phoneNumberField).getAttribute("value");
        Assert.assertEquals(PhoneNumberValue, phoneNumber);
        return this;
    }

    @Step("Click Send money request button")
    public NewPaymentRequestPage ClickSendMoneyRequestButton() {
        driver.findElement(sendMoneyRequestButton).click();
        return this;
    }
    @Step("Check valid payment status")
    public NewPaymentRequestPage CheckValidPaymentStatus() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentStatus));
        String PaymentStatusTitle = driver.findElement(paymentStatus).getText();
        Assert.assertTrue(PaymentStatusTitle.contains("Payment Created"));
        return this;
    }
    @Step("Check amount details")
    public NewPaymentRequestPage CheckAmountDetails(String amount) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountDetail));
        String AmountValue = driver.findElement(amountDetail).getText();
        Assert.assertEquals(AmountValue, amount);
        return this;
    }
    @Step("Check reference details")
    public NewPaymentRequestPage CheckReferenceDetails(String reference) {
        String ReferenceValue = driver.findElement(referenceDetail).getText();
        Assert.assertEquals(ReferenceValue, reference);
        return this;
    }
    @Step("Check name details")
    public NewPaymentRequestPage CheckNameDetails(String name) {
        String NameValue = driver.findElement(nameDetail).getText();
        Assert.assertEquals(NameValue, name);
        return this;
    }
    @Step("Check email details")
    public NewPaymentRequestPage CheckEmailDetails(String email) {
        String EmailValue = driver.findElement(emailDetail).getText();
        Assert.assertEquals(EmailValue, email);
        return this;
    }
    @Step("Check phone number details")
    public NewPaymentRequestPage CheckPhoneNumberDetails(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberDetail));
        String PhoneNumberValue = driver.findElement(phoneNumberDetail).getText();
        Assert.assertEquals(PhoneNumberValue, phoneNumber);
        return this;
    }
    @Step("Check payment history")
    public NewPaymentRequestPage CheckPaymentHistory() {
        String PaymentHistoryValue = driver.findElement(paymentHistory).getText();
        Assert.assertTrue(PaymentHistoryValue.contains("The payment has been created"));
        return this;
    }
    @Step("Check empty field error")
    public NewPaymentRequestPage CheckEmptyFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialError));
        String EmptyFieldErrorValue = driver.findElement(invalidCredentialError).getText();
        Assert.assertTrue(EmptyFieldErrorValue.contains("Fill in the required fields"));
        return this;
    }
}
