package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement userNameBox;
    WebElement passwordBox;
    WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUserNameBox() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordBox() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("radius"));
    }

    public void insertUserName(String username){
        getUserNameBox().sendKeys(username);
    }
    public void insertPassword(String password){
        getPasswordBox().sendKeys(password);
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }
}
