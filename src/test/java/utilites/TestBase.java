package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeClass
    public void setDriver() {
        Driver.setDriver();
    }

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(Config.getProperty("url"));
        Driver.getDriver().findElement(By.id("login")).sendKeys(Config.getProperty("login"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(Config.getProperty("password") + Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://54.148.96.210/web/login");
        Driver.getDriver().findElement(By.linkText("Invoicing")).click();
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Customer Invoices - Odoo");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(10000);
        Driver.getDriver().close();
    }

}
