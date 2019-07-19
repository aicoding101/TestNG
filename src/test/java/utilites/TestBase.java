package utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static utilites.SAD.*;

public class TestBase {

//    @BeforeClass
//    public void setDriver() {
//        Driver.setDriver();
//    }

//    @BeforeMethod
//    public void setUp() {
//        Driver.getDriver().get(Config.getProperty("url"));
//        Driver.getDriver().findElement(By.id("login")).sendKeys(Config.getProperty("login"));
//        Driver.getDriver().findElement(By.id("password")).sendKeys(Config.getProperty("password") + Keys.ENTER);
//        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://54.148.96.210/web/login");
//        Driver.getDriver().findElement(By.linkText("Inventory")).click();
//        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Inventory - Odoo");
//    }

    @BeforeMethod
    public void Setup(){
        SAD.SetChromeDriver("http://54.148.96.210/web/login");
        SAD.MaximizeWindow();
        SAD.FindAndSendKeys(Locators.id, "login", "inm3@info.com");
        SAD.FindAndSendKeysENTER(Locators.id, "password", "alsfuh7we69");
        SAD.FindAndClick(Locators.linkText, "Inventory");
    }

    @AfterMethod
    public void tearDown() {
        SAD.ThatsIt();
    }

}