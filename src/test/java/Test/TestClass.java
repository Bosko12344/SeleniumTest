package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {
    String validUserName = "tomsmith";
    String validPassword = "SuperSecretPassword!";

    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
    @Test
    public void testWithValidUsernameAndPassword() throws InterruptedException {
       // Thread.sleep(2000);
    loginPage.insertUserName(validUserName);
    loginPage.insertPassword(validPassword);
    loginPage.clickOnLoginButton();

        //Nisam siguran na koji nacin je trebalo pa sam ostavio u komentar jedan nacin, a uradio na drugi.Vazi za sve aserte
        //Ovde proveravamo da li se prikazuje poruka za uspesan Login
        //WebElement message = driver.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(sitePage.getMessage().isDisplayed());

    //Ovde sam proverio da li je prikazano dugme logout. U slucaju ispravnog logina, log out dugme treba biti prikazano
    //WebElement logoutButton = driver.findElement(By.cssSelector(".button.secondary.radius"));
        Assert.assertTrue(sitePage.getLogoutButton().isDisplayed());

    //Proveravamo da li se linkovi podudaraju za uspesan login.
    Assert.assertEquals(driver.getCurrentUrl(), sitePage.getLink());

    //Proveramo da li je ispisana poruka: Welcome to the Secure Area. When you are done click logout below.
    Assert.assertTrue(sitePage.getSecureArea().isDisplayed());
    }
    @Test
    public void testWithInvalidUsernameAndValidPassword(){
        loginPage.insertUserName("bosko");
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        //provera da logout dugme ne postoji
        boolean check = false;
        try {
            check = sitePage.getLogoutButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
        //provera da poruka za uspesan log in ne postoji
        boolean check1 = false;
        try {
            check1 = sitePage.getMessage().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check1);
        //proveramo da li je prikazana poruka za neuspesan login
        Assert.assertTrue(sitePage.getMessageForInvalidUsernameOrPassword().isDisplayed());
    }
    @Test
    public void testWithValidUsernameAndInvalidPassword(){
        loginPage.insertUserName(validUserName);
        loginPage.insertPassword("bosko1234");
        loginPage.clickOnLoginButton();
        //provera da ne postoji log out dugme
        boolean check = false;
        try {
            check = sitePage.getLogoutButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
        //provera da poruka za uspesan log in ne postoji
        boolean check1 = false;
        try {
            check1 = sitePage.getMessage().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check1);
        //provera da je prikazana poruka za neuspesan login
        Assert.assertTrue(sitePage.getMessageForInvalidUsernameOrPassword().isDisplayed());


    }
    @Test
    public void testWithInvalidUsernameAndInvalidPassword(){
        loginPage.insertUserName("bosko");
        loginPage.insertPassword("bosko1234");
        loginPage.clickOnLoginButton();
        //provera da ne postoji log out dugme
        boolean check = false;
        try {
            check = sitePage.getLogoutButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
        //provera da poruka za uspesan login ne postoji
        boolean check1 = false;
        try {
            check1 = sitePage.getMessage().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check1);
        //provera da je prikazana poruka za neuspesan login
        Assert.assertTrue(sitePage.getMessageForInvalidUsernameOrPassword().isDisplayed());
    }
    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }

   
}

