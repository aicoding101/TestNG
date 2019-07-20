package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.*;

public class Ameer extends TestBase {
    @Test
    public void WarehouseManagement(){
        SAD.WaitTime(20);

        SAD.FindAndClick(Locators.xpath, "//span[contains(text(),'Warehouse Management')]");

        SAD.FindAndClick(Locators.xpath, "//span[contains(text(),'Warehouses')]");

        Assert.assertFalse(SAD.getDriver().findElement(By.xpath("//tbody//input")).isSelected());
        SAD.FindAndClick(Locators.xpath, "//tbody//input");
        Assert.assertTrue(SAD.getDriver().findElement(By.xpath("//tbody//input")).isSelected());
        Assert.assertEquals(SAD.getDriver().getTitle(), "Warehouses - Odoo");

        Assert.assertTrue(SAD.FindAndDisplay(Locators.xpath, "//button[contains(text(),'Action')]"));
        SAD.FindAndClick(Locators.xpath, "//button[contains(text(),'Action')]");

        Assert.assertTrue(SAD.FindAndDisplay(Locators.xpath, "//a[contains(text(),'Delete')]"));
        SAD.FindAndClick(Locators.xpath, "//a[contains(text(),'Delete')]");

        Assert.assertEquals(SAD.GetWebElement(Locators.className, "modal-body").getText(), "Are you sure you want to delete this record ?");
        SAD.FindAndClick(Locators.xpath, "//span[contains(text(),'Ok')]");

        Assert.assertTrue(SAD.FindAndDisplay(Locators.xpath, "//h4[contains(text(),'Odoo Server Error')]"));
        SAD.FindAndClick(Locators.xpath, "//span[contains(text(),'Ok')]");
    }

    //    PLEASE READ COMMENTS INSIDE ProductGeneralInfo() AFTER FIRST TEST
//    SOME VALUES MUST BE CHANGED AFTER RUNNING THE TEST ONCE TO ENSURE PROPER RUN AFTERWARDS
//    VALUES TO CHANGE ARE SURROUNDED WITH --> /*change*/VALUE/*change*/
    @Test
    public void ProductGeneralInfo() throws InterruptedException{
        SAD.WaitTime(20);

        SAD.FindAndClick(Locators.xpath, "//span[contains(text(),'Products')]");
        Assert.assertTrue(SAD.FindAndDisplay(Locators.xpath, "//li[contains(text(),'Products')]"));

        SAD.FindAndClick(Locators.xpath, "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']");

//        NAME:
//        MUST BE DIFFERENT EACH TEST
        SAD.FindAndSendKeys(Locators.xpath, "//input[@placeholder='Product Name']", /*change*/"Aibek's Glasses"/*change*/);

        SAD.FindAndClick(Locators.xpath, "//select[@class='o_input o_field_widget o_required_modifier']");
        SAD.FindAndClick(Locators.xpath, "//option[contains(text(),'Stockable Product')]");

        SAD.FindAndClick(Locators.xpath, "//input[@class='o_input ui-autocomplete-input']");
        SAD.FindAndClick(Locators.xpath, "//a[contains(text(),'All / Artistic')]");

        SAD.ClearField(Locators.name, "default_code");
        SAD.FindAndSendKeys(Locators.name, "default_code", "Reference Name");

        SAD.ClearField(Locators.name, "barcode");

//        MUST BE DIFFERENT EACH TEST
        SAD.FindAndSendKeys(Locators.name, "barcode", /*change*/"#1234567900"/*change*/);

        SAD.FindAndClick(Locators.xpath, "//input[@class='o_input']");
        SAD.ClearField(Locators.xpath, "//input[@class='o_input']");
        SAD.FindAndSendKeys(Locators.xpath, "//input[@class='o_input']", "1000000.00");

        SAD.FindAndClick(Locators.xpath, "//td//div//div//input[@class='o_input']");
        SAD.ClearField(Locators.xpath, "//td//div//div//input[@class='o_input']");
        SAD.FindAndSendKeys(Locators.xpath, "//td//div//div//input[@class='o_input']", "1050000.00");

        SAD.FindAndClick(Locators.xpath, "//button[contains(text(),'Save')]");

        Thread.sleep(2000);
//        CHANGE ACCORDING TO NAME ABOVE
        Assert.assertEquals(SAD.GetWebElement(Locators.xpath, "//ol//li[@class='active']").getText(), "[Reference Name] " + /*change*/"Aibek's Glasses"/*change*/);

    }
}
