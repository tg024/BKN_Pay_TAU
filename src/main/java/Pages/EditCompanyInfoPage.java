package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EditCompanyInfoPage {
    WebDriver driver;

    public EditCompanyInfoPage (WebDriver driver) {this.driver = driver;}

    By settingsOverviewButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/nb-sidebar/div/div/nb-menu/ul/li[4]/ul/li[1]/a/span");
    By settingsOverviewPage = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-header/ngx-settings-header/div/div[1]/h4");
    By editCompanyInfoButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-header/ngx-settings-header/div/div[2]/button");
    By editCompanyInfoPage = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-company-info/nb-card/nb-card-header/div/div/h4");
    By companyNameField = By.id("companyName");
    By representativeField = By.id("representativeName");
    By representativeEmailField = By.id("email");
    By phoneNumberField = By.id("phoneNumber");
    By ibanField = By.id("iban");
    By successMessage = By.id("swal2-title");
    By saveButton = By.className("ant-btn");
    By companyNameDetails = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/ngx-settings-submerchant-detail/div[1]/div[1]/div");
    By representativeNameDetails = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/ngx-settings-submerchant-detail/div[1]/div[2]/div");
    By representativeEmailDetails = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/ngx-settings-submerchant-detail/div[2]/div[2]/div");
    By phoneNumberDetails = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/ngx-settings-submerchant-detail/div[2]/div[1]/div");
    By fieldErrorMessage = By.className("text-danger");
    By emptyFieldErrorMessage = By.id("swal2-title");


    @Step ("Check Settings Overview button")
    public EditCompanyInfoPage CheckSettingsOverviewButton () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsOverviewButton));
        Assert.assertTrue(driver.findElement(settingsOverviewButton).isDisplayed());
        return this;
    }

    @Step ("Click on the Settings Overview button")
    public EditCompanyInfoPage ClickSettingsOverviewButton () {
        driver.findElement(settingsOverviewButton).click();
        return this;
    }
    @Step ("Check Settings Overview page")
    public EditCompanyInfoPage CheckSettingsOverviewPage () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsOverviewPage));
        Assert.assertTrue(driver.findElement(settingsOverviewPage).isDisplayed());
        return this;
    }
    @Step ("Check Edit Company Info button")
    public EditCompanyInfoPage CheckEditCompanyInfoButton () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(editCompanyInfoButton));
        Assert.assertTrue(driver.findElement(editCompanyInfoButton).isDisplayed());
        return this;
    }
    @Step ("Click Edit Company Info button")
    public EditCompanyInfoPage ClickEditCompanyInfoButton () {
        driver.findElement(editCompanyInfoButton).click();
        return this;
    }
    @Step ("Check Edit Company Info page")
    public EditCompanyInfoPage CheckEditCompanyInfoPage () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(editCompanyInfoPage));
        Assert.assertTrue(driver.findElement(editCompanyInfoPage).isDisplayed());
        return this;
    }
    @Step ("Check Company name field")
    public EditCompanyInfoPage CheckCompanyNameField () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(companyNameField));
        return this;
    }
    @Step ("Enter Company name")
    public EditCompanyInfoPage EnterCompanyName (String companyName) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(companyNameField).clear();
        driver.findElement(companyNameField).sendKeys(companyName);
        String CompanyNameValue = driver.findElement(companyNameField).getAttribute("value");
        Assert.assertEquals(CompanyNameValue, companyName);
        return this;
    }
    @Step ("Check Representative field")
    public EditCompanyInfoPage CheckRepresentativeField () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(representativeEmailField));
        return this;
    }
    @Step ("Enter Representative")
    public EditCompanyInfoPage EnterRepresentative (String representative) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(representativeField).clear();
        driver.findElement(representativeField).sendKeys(representative);
        String RepresentativeValue = driver.findElement(representativeField).getAttribute("value");
        Assert.assertEquals(RepresentativeValue, representative);
        return this;
    }
    @Step ("Check Representative Email field")
    public EditCompanyInfoPage CheckRepresentativeEmailField () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(representativeEmailField));
        return this;
    }
    @Step ("Enter Representative Email")
    public EditCompanyInfoPage EnterRepresentativeEmail (String representativeEmail) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(representativeEmailField).clear();
        driver.findElement(representativeEmailField).sendKeys(representativeEmail);
        String RepresentativeEmailValue = driver.findElement(representativeEmailField).getAttribute("value");
        Assert.assertEquals(RepresentativeEmailValue,representativeEmail );
        return this;
    }
    @Step ("Check Phone number field")
    public EditCompanyInfoPage CheckPhoneNumberField () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
        return this;
    }
    @Step ("Enter Phone number")
    public EditCompanyInfoPage EnterPhoneNumber (String phoneNumber) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        String PhoneNumberValue = driver.findElement(phoneNumberField).getAttribute("value");
        Assert.assertEquals(PhoneNumberValue, phoneNumber);
        return this;
    }
    @Step ("Check IBAN field")
    public EditCompanyInfoPage CheckIbanField () {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(ibanField));
        return this;
    }
    @Step ("Enter IBAN")
    public EditCompanyInfoPage EnterIban (String iban) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(ibanField).clear();
        driver.findElement(ibanField).sendKeys(iban);
        String IbanValue = driver.findElement(ibanField).getAttribute("value");
        Assert.assertEquals(IbanValue, iban);
        return this;
    }
    @Step ("Check Save button")
    public EditCompanyInfoPage CheckSaveButton () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        return this;
    }
    @Step ("Click Save button")
    public EditCompanyInfoPage ClickSaveButton () {
        driver.findElement(saveButton).click();
        return this;
    }
    @Step ("Check success message")
    public EditCompanyInfoPage CheckSuccessMessage () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        String SuccessMessageValue = driver.findElement(successMessage).getText();
        Assert.assertTrue(SuccessMessageValue.contains("Company info updated successful"));
        return this;
    }
    @Step ("Check saved Company Name after edit")
    public EditCompanyInfoPage CheckSavedCompanyName (String companyName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyNameDetails));
        String SavedCompanyNameValue = driver.findElement(companyNameDetails).getText();
        Assert.assertEquals(SavedCompanyNameValue, companyName);
        return this;
    }
    @Step ("Check saved Representative Name after edit")
    public EditCompanyInfoPage CheckSavedRepresentative (String representativeName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(representativeNameDetails));
        String SavedRepresentativeValue = driver.findElement(representativeNameDetails).getText();
        Assert.assertEquals(SavedRepresentativeValue, representativeName);
        return this;
    }
    @Step ("Check saved Email after edit")
    public EditCompanyInfoPage CheckSavedRepresentativeEmail (String representativeEmail) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(representativeEmailDetails));
        String SavedRepresentativeEmail = driver.findElement(representativeEmailDetails).getText();
        Assert.assertEquals(SavedRepresentativeEmail, representativeEmail);
        return this;
    }
    @Step ("Check saved Phone Number after edit")
    public EditCompanyInfoPage CheckSavedPhoneNumber (String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberDetails));
        String SavedPhoneNumberValue = driver.findElement(phoneNumberDetails).getText();
        Assert.assertEquals(SavedPhoneNumberValue, phoneNumber);
        return this;
    }
    @Step ("Check empty field Error")
    public EditCompanyInfoPage CheckEmptyFieldError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyFieldErrorMessage));
        String EmptyFieldErrorValue = driver.findElement(emptyFieldErrorMessage).getText();
        Assert.assertTrue(EmptyFieldErrorValue.contains("Fill in the required fields"));
        return this;
    }
    @Step ("Check invalid format Email error")
    public EditCompanyInfoPage CheckInvalidEmailError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldErrorMessage));
        String InvalidFormatEmailErrorValue = driver.findElement(fieldErrorMessage).getText();
        Assert.assertTrue(InvalidFormatEmailErrorValue.contains("This field is not a valid email!"));
        return this;
    }
    @Step ("Check invalid format number error")
    public EditCompanyInfoPage CheckInvalidFormatNumberError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldErrorMessage));
        String InvalidFormatEmailErrorValue = driver.findElement(fieldErrorMessage).getText();
        Assert.assertTrue(InvalidFormatEmailErrorValue.contains("This field is not a valid phone number!"));
        return this;
    }
}
