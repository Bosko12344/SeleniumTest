package Base;

import Pages.LoginPage;
import Pages.SitePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
public WebDriver driver;
public WebDriverWait wdwait;
public LoginPage loginPage;
public SitePage sitePage;

@BeforeClass
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    wdwait=new WebDriverWait(driver, Duration.ofSeconds(10));
    loginPage = new LoginPage(driver,wdwait);
    sitePage = new SitePage(driver,wdwait);


}
@AfterClass
public void tearDown() {
    driver.close();
    driver.quit();
}
}
