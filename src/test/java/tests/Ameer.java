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
        SAD.PageLoadWaitTime(20);

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

    @Test
    public void ProductGeneralInfo(){
        SAD.FindAndClick(Locators.xpath, "//span[contains(text(),'Products')]");
        Assert.assertTrue(SAD.FindAndDisplay(Locators.xpath, "//li[contains(text(),'Products')]"));

        SAD.FindAndClick(Locators.xpath, "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']");

        SAD.FindAndSendKeys(Locators.xpath, "//input[@placeholder='Product Name']", "Sample Product");

//        SAD.FindAndClick(Locators.className, "o_input o_field_widget o_required_modifier");
//        SAD.FindAndClick(Locators.xpath, "//option[@value='\"product\"']");
//
//        SAD.FindAndClick(Locators.xpath, "//input[@class='o_input ui-autocomplete-input']");
//        SAD.FindAndClick(Locators.xpath, "//a[contains(text(),'All / Artistic')]");

        SAD.ClearField(Locators.name, "default_code");
        SAD.FindAndSendKeys(Locators.name, "default_code", "Reference Name");

        SAD.ClearField(Locators.name, "barcode");
        SAD.FindAndSendKeys(Locators.name, "barcode", "#1234567890");

        SAD.ClearField(Locators.xpath, "//input[@class='o_input']");
        SAD.FindAndSendKeys(Locators.xpath, "//input[@class='o_input']", "200.00");

        SAD.ClearField(Locators.xpath, "//td//div//div//input[@class='o_input']");
        SAD.FindAndSendKeys(Locators.xpath, "//td//div//div//input[@class='o_input']", "175.00");

        SAD.FindAndClick(Locators.xpath, "//button[contains(text(),'Save')]");



        Assert.assertEquals(SAD.GetWebElement(Locators.xpath, "//ol//li[@class='active']").getText(), "Sample Product");

    }

}
