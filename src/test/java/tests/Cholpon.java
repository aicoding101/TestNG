package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.Driver;

public class Cholpon {

    Actions actions;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("http://54.148.96.210/web/login");

        WebElement login = Driver.getDriver().findElement(By.id("login"));
        login.sendKeys("in@info.com" + Keys.ENTER);

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("alsfuh7we67" + Keys.ENTER);

        WebElement inventory = Driver.getDriver().findElement(By.linkText("Inventory"));
        inventory.click();

    }

    @Test
    public void createProduct() throws Exception {


        WebElement products = Driver.getDriver().findElement(By.linkText("Products"));
        products.click();

        Thread.sleep(2000);
        WebElement createButton = Driver.getDriver().findElement(By.xpath("//div[@class='o_cp_buttons']//div[1]//button[1]"));
        createButton.click();

        WebElement purchaseTab = Driver.getDriver().findElement(By.linkText("Purchase"));
        purchaseTab.click();

        WebElement findAnItemTab = Driver.getDriver().findElement(By.linkText("Add an item"));
        findAnItemTab.click();


        WebElement vendorTab = Driver.getDriver().findElement(By.id("o_field_input_574"));

        Thread.sleep(1000);
        WebElement productName = Driver.getDriver().findElement(By.id("o_field_input_575"));
        productName.click();

        WebElement productCode = Driver.getDriver().findElement(By.id("o_field_input_576"));
        productCode.click();

        WebElement deliveryLeadTime = Driver.getDriver().findElement(By.id("o_field_input_577"));
        deliveryLeadTime.click();

        WebElement minimalQuantity = Driver.getDriver().findElement(By.id("o_field_input_579"));
        minimalQuantity.click();

        WebElement priceField = Driver.getDriver().findElement(By.id("o_field_input_581"));
        priceField.click();

        WebElement validityStartDate = Driver.getDriver().findElement(By.id("o_field_input_583"));
        validityStartDate.sendKeys("01-01-2019");
        validityStartDate.click();


        Thread.sleep(2000);
        WebElement vaidityEndDate = Driver.getDriver().findElement(By.id("o_field_input_584"));
        vaidityEndDate.sendKeys("01-30-2019");
        vaidityEndDate.click();

        Thread.sleep(1000);
        WebElement saveAndClose = Driver.getDriver().findElement(By.xpath("//div[@class='modal-footer']/button[1]"));
        saveAndClose.click();


        WebElement discard = Driver.getDriver().findElement(By.xpath("//div[@class='modal-footer']//button[3]//span"));
        discard.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://54.148.96.210/web?#id=&view_type=form&model=product.template&menu_id=378&action=521", "Discard Button verification is Not Passes");

    }


    @Test
    public void SmokeSuite255() throws InterruptedException {

        WebElement inventoryValuation = Driver.getDriver().findElement(By.linkText("Inventory Valuation"));
        inventoryValuation.click();

        WebElement retriveButton = Driver.getDriver().findElement(By.xpath("//button[@name='open_table']/span"));
        retriveButton.click();

        Thread.sleep(3000);
        WebElement searchBox = Driver.getDriver().findElement(By.className("o_searchview_input"));
        searchBox.sendKeys("ice cream" + Keys.ENTER);

        WebElement a = Driver.getDriver().findElement(By.className("ui-sortable"));

        Assert.assertTrue(a.isDisplayed());

    }
}






