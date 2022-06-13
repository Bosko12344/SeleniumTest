package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SitePage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement message;
    WebElement logoutButton;
    String link = "https://the-internet.herokuapp.com/secure";
    WebElement messageForInvalidUsernameOrPassword;
    WebElement secureArea;

    public SitePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getMessage() {
        return driver.findElement(By.cssSelector(".flash.success"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".button.secondary.radius"));
    }

    public String getLink() {
        return link;
    }

    public WebElement getMessageForInvalidUsernameOrPassword() {
        return driver.findElement(By.cssSelector(".flash.error"));
    }

    public WebElement getSecureArea() {
        return driver.findElement(By.className("subheader"));
    }

    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }
}
