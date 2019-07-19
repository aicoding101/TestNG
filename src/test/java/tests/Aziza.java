package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.Config;
import utilites.Driver;

public class Aziza {

    @Test

    public void cancelFileImport(){

        Driver.getDriver().get(Config.getProperty("url"));

        WebElement login = Driver.getDriver().findElement(By.id("login"));
        login.sendKeys(Config.getProperty("username"));
//
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys(Config.getProperty("password") + Keys.ENTER);

        WebElement inventoryTab = Driver.getDriver().findElement(By.xpath("//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[6]/a/span"));
        inventoryTab.click();

        WebElement transfersTab = Driver.getDriver().findElement(By.xpath("//div[@class='o_sub_menu_content']/div[6]//ul[1]/li[1]/a[1]"));
        transfersTab.click();


        WebElement importButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-default o_button_import']"));
        importButton.click();
        Assert.assertTrue(importButton.isDisplayed(), "Import button is not displayed");


        WebElement cancelButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-default o_import_cancel']"));
        cancelButton.click();
        Assert.assertTrue(cancelButton.isDisplayed(), "Cancel button is not displayed");


    }

}
