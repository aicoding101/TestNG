package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.Driver;
import utilites.SAD;
import utilites.TestBase;

public class Cholpon extends TestBase {

    Actions actions;

//    @BeforeMethod
//    public void setUp() {
//        SAD.getDriver().get("http://54.148.96.210/web/login");
//
//        WebElement login = SAD.getDriver().findElement(By.id("login"));
//        login.sendKeys("in@info.com" + Keys.ENTER);
//
//        WebElement password = SAD.getDriver().findElement(By.id("password"));
//        password.sendKeys("alsfuh7we67" + Keys.ENTER);
//
//        WebElement inventory = SAD.getDriver().findElement(By.linkText("Inventory"));
//        inventory.click();
//
//    }

    @Test
    public void createProduct() {


        WebElement products = SAD.getDriver().findElement(By.linkText("Products"));
        products.click();

        WebElement createButton = SAD.getDriver().findElement(By.xpath("//div[@class='o_cp_buttons']//div[1]//button[1]"));
        createButton.click();

        WebElement purchaseTab = SAD.getDriver().findElement(By.linkText("Purchase"));
        purchaseTab.click();

        WebElement findAnItemTab = SAD.getDriver().findElement(By.linkText("Add an item"));
        findAnItemTab.click();


        WebElement vendorTab = SAD.getDriver().findElement(By.id("o_field_input_574"));

        WebElement productName = SAD.getDriver().findElement(By.id("o_field_input_575"));
        productName.click();

        WebElement productCode = SAD.getDriver().findElement(By.id("o_field_input_576"));
        productCode.click();

        WebElement deliveryLeadTime = SAD.getDriver().findElement(By.id("o_field_input_577"));
        deliveryLeadTime.click();

        WebElement minimalQuantity = SAD.getDriver().findElement(By.id("o_field_input_579"));
        minimalQuantity.click();

        WebElement priceField = SAD.getDriver().findElement(By.id("o_field_input_581"));
        priceField.click();

        WebElement validityStartDate = SAD.getDriver().findElement(By.id("o_field_input_583"));
        validityStartDate.sendKeys("01-01-2019");
        validityStartDate.click();


        WebElement vaidityEndDate = SAD.getDriver().findElement(By.id("o_field_input_584"));
        vaidityEndDate.sendKeys("01-30-2019");
        vaidityEndDate.click();

        WebElement saveAndClose = SAD.getDriver().findElement(By.xpath("//div[@class='modal-footer']/button[1]"));
        saveAndClose.click();


        WebElement discard = SAD.getDriver().findElement(By.xpath("//div[@class='modal-footer']//button[3]//span"));
        discard.click();
        Assert.assertEquals(SAD.getDriver().getCurrentUrl(), "http://54.148.96.210/web?#id=&view_type=form&model=product.template&menu_id=378&action=521", "Discard Button verification is Not Passes");

    }


    @Test
    public void SmokeSuite255() {

        WebElement inventoryValuation = SAD.getDriver().findElement(By.linkText("Inventory Valuation"));
        inventoryValuation.click();

        WebElement retriveButton = SAD.getDriver().findElement(By.xpath("//button[@name='open_table']/span"));
        retriveButton.click();

        WebElement searchBox = SAD.getDriver().findElement(By.className("o_searchview_input"));
        searchBox.sendKeys("ice cream" + Keys.ENTER);

        WebElement ab = SAD.getDriver().findElement(By.className("ui-sortable"));

        Assert.assertTrue(ab.isDisplayed());

    }
}






