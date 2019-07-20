package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.Config;
import utilites.Driver;

public class Tugba {
    @Test
    public void Tugbasmethod() throws Exception{
        Driver.getDriver().get(Config.getProperty("url"));
        WebElement login = Driver.getDriver().findElement(By.id("login"));
        login.sendKeys(Config.getProperty("username"));
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys(Config.getProperty("password") + Keys.ENTER);
        Thread.sleep(2000);
        WebElement inventory = Driver.getDriver().findElement(By.linkText("Inventory"));
        inventory.click();
        WebElement transferTab = Driver.getDriver().findElement(By.linkText("Transfers"));
        transferTab.click();
        Thread.sleep(3000);
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/input"));
        Thread.sleep(3000);
        searchBox.sendKeys("anything" + Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://54.148.96.210/web?#view_type=list&model=stock.picking&menu_id=368&action=490","Search Box verification is FAILED!");
    }
}


