package Pages;

import CommonSteps.CommonSteps;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Key;

public class AddNewUserPage {
    WebDriver driver;

    public AddNewUserPage (WebDriver driver) {this.driver = driver;}

    By addNewUserButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-header/ngx-users-header/div/div[2]/button");
    By pageTitle = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-body/div/div[1]/h4");
    By fullNameField = By.id("fullname");
    By emailField = By.id("email");
    By roleField = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-body/div/div[2]/form/nz-form-item[3]/nz-form-control/div/div/nz-select/nz-select-top-control/nz-select-search/input");
    By saveButton = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-footer/div/div[2]/button[2]");
    By modalMessage = By.className("swal2-title");
    By emailFieldError = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-body/div/div[2]/form/nz-form-item[2]/nz-form-control/div/div/div/small");
    By fullNameFieldError = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-body/div/div[2]/form/nz-form-item[1]/nz-form-control/div/div/div/small");
    By noRoleFoundError = By.xpath("ant-select-item-empty");
    By emptyRoleError = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-body/div/div[2]/form/nz-form-item[3]/nz-form-control/div/div/div");
    By emptyFullNameError = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-body/div/div[2]/form/nz-form-item[1]/nz-form-control/div/div/div/small");
    By emptyEmailError = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-user-new/nz-spin/div/nb-card/nb-card-body/div/div[2]/form/nz-form-item[2]/nz-form-control/div/div/div/small");

    @Step ("Click Add new user button")
    public void ClickAddNewUserButton () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(addNewUserButton));
        driver.findElement(addNewUserButton).click();
    }
    @Step ("Check Add new user page")
    public void CheckAddNewUserPage () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        String PageTitleValue = driver.findElement(pageTitle).getText();
        Assert.assertTrue(PageTitleValue.contains("Add new user"));
    }
    @Step ("Enter Full name")
    public void EnterFullName (String fullName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField));
        driver.findElement(fullNameField).sendKeys(fullName);
        String FullNameValue = driver.findElement(fullNameField).getAttribute("value");
        Assert.assertEquals(FullNameValue, fullName);
    }
    @Step ("Enter Email address")
    public void EnterEmail (String email) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
        String EmailValue = driver.findElement(emailField).getAttribute("value");
        Assert.assertEquals(EmailValue, email);
    }
    @Step ("Choose role")
    public void ChooseRole (String role) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(roleField));
        driver.findElement(roleField).sendKeys(role);
        String RoleValue = driver.findElement(roleField).getAttribute("value");
        Assert.assertEquals(RoleValue, role);
        driver.findElement(roleField).sendKeys(Keys.ENTER);
    }
    @Step ("Click Save button")
    public void ClickSaveButton () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
    }
    @Step ("Check success message")
    public void CheckSuccessMessage () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalMessage));
        String ModalMessageText = driver.findElement(modalMessage).getText();
        Assert.assertTrue(ModalMessageText.contains("The new user was added successfully"));
    }
    @Step ("Check invalid format Email error")
    public void CheckInvalidEmailError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldError));
        String InvalidEmailError = driver.findElement(emailFieldError).getText();
        Assert.assertTrue(InvalidEmailError.contains("This field is not a valid email!"));
    }
    @Step ("Check invalid format First name error")
    public void CheckInvalidFullNameError () {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameFieldError));
        String InvalidFullNameError = driver.findElement(fullNameFieldError).getText();
        Assert.assertTrue(InvalidFullNameError.contains("This field is not valid: please insert only letters!"));
    }
    @Step ("Check No role found error")
    public void CheckNoRoleFoundError () {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(noRoleFoundError));
        String NoRoleFoundError = driver.findElement(noRoleFoundError).getText();
        System.out.println(NoRoleFoundError + "+++++");
        Assert.assertTrue(NoRoleFoundError.contains("No Data"));
    }
    @Step ("Check empty role error")
    public void CheckEmptyRoleError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyRoleError));
        String EmptyRoleError = driver.findElement(emptyRoleError).getText();
        Assert.assertTrue(EmptyRoleError.contains("This field is required!"));
    }
    @Step ("Check empty Full name error")
    public void CheckEmptyFullNameError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyFullNameError));
        String EmptyFullNameError = driver.findElement(emptyFullNameError).getText();
        Assert.assertTrue(EmptyFullNameError.contains("This field is required!"));
    }
    @Step ("Check empty Email error")
    public void CheckEmptyEmailError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyEmailError));
        String EmptyEmailError = driver.findElement(emptyEmailError).getText();
        Assert.assertTrue(EmptyEmailError.contains("This field is required!"));
    }
}
