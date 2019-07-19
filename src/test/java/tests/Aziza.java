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

public class Aziza extends TestBase {
    @Test
    public void cancelFileImport(){

//        SAD.getDriver().get(Config.getProperty("url"));
//
//        WebElement login = SAD.getDriver().findElement(By.id("login"));
//        login.sendKeys(Config.getProperty("username"));
//
//        WebElement password = SAD.getDriver().findElement(By.id("password"));
//        password.sendKeys(Config.getProperty("password") + Keys.ENTER);

//        WebElement inventoryTab = SAD.getDriver().findElement(By.xpath("//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[6]/a/span"));
//        inventoryTab.click();

        WebElement transfersTab = SAD.getDriver().findElement(By.xpath("//div[@class='o_sub_menu_content']/div[6]//ul[1]/li[1]/a[1]"));
        transfersTab.click();


        WebElement importButton = SAD.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-default o_button_import']"));
        importButton.click();
        Assert.assertTrue(importButton.isDisplayed(), "Import button is not displayed");


        WebElement cancelButton = SAD.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-default o_import_cancel']"));
        cancelButton.click();
        Assert.assertTrue(cancelButton.isDisplayed(), "Cancel button is not displayed");

    }
}
