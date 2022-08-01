package Pages;

import CommonSteps.CommonSteps;
import DataObject.UsersData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;

import static DataObject.UsersData.*;

public class UsersPage {
    WebDriver driver;

    public UsersPage (WebDriver driver) {this.driver = driver;}

    By usersPageTitle = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-header/ngx-users-header/div/div[1]/h4");
    By searchNameField = By.className("ant-input");
    By foundedUser = By.xpath("/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ng-component/nb-card/nb-card-body/ngx-users-table/div/nz-table/nz-spin/div/div/nz-table-inner-default/div/table/tbody/tr/td[2]");
    By userNotFoundError = By.className("ant-empty-description");

    @Step ("Check page title")
    public void CheckPageTitle () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersPageTitle));
        String PageTitleValue = driver.findElement(usersPageTitle).getText();
        Assert.assertTrue(PageTitleValue.contains("Users"));
    }

    @Step ("Enter user name")
    public void EnterUserName (String userName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchNameField));
        driver.findElement(searchNameField).click();
        driver.findElement(searchNameField).sendKeys(userName);
        String UserNameValue = driver.findElement(searchNameField).getAttribute("value");
        Assert.assertEquals(UserNameValue, userName);
    }
    @Step ("Check founded user")
    public void CheckFoundedUser (String userName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(foundedUser));
        String FoundedUserName = driver.findElement(foundedUser).getText();
        Assert.assertEquals(FoundedUserName, userName);
    }
    @Step ("Check user not found error message")
    public void CheckUserNotFoundError () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNotFoundError));
        String UserNotFoundError = driver.findElement(userNotFoundError).getText();
        Assert.assertTrue(UserNotFoundError.contains("No Data"));
    }
}
