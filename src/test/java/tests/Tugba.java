package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.Config;
import utilites.Driver;
import utilites.SAD;
import utilites.TestBase;

public class Tugba extends TestBase {
    @Test
    public void Tugbasmethod() throws InterruptedException{
        SAD.WaitTime(20);
        WebElement transferTab = Driver.getDriver().findElement(By.linkText("Transfers"));
        transferTab.click();
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/input"));
        searchBox.sendKeys("anything" + Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://54.148.96.210/web?#view_type=list&model=stock.picking&menu_id=368&action=490","Search Box verification is FAILED!");
    }
}


