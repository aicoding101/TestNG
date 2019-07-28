package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.*;

public class SmokeTest extends TestBase {

//    AMEER
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


//    AISULUU
    @Test
    public void discardFile(){
        WebElement inventoryAdjustment = Driver.getDriver().findElement(By.linkText("Inventory Adjustments"));
        inventoryAdjustment.click();


        WebElement importButtton = Driver.getDriver().
                findElement(By.xpath("//button[@class='btn btn-sm btn-default o_button_import']"));
        importButtton.click();

        WebElement fileLoad = Driver.getDriver().
                findElement(By.xpath("//label[@class='btn btn-primary']"));
        //fileLoad.click();

        WebElement uploadFile = Driver.getDriver().findElement(By.id("my-file-selector"));
        //WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//div[@class='input-group']/input"));

        //div[@class='input-group']/input

//      //   uploadFile.sendKeys("/Users/aisu/Downloads/C2ImportCalEventSample.csv");
//           uploadFile.sendKeys(Keys.ENTER);

        WebElement cancelButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-default o_import_cancel']"));
        cancelButton.click();

        WebElement createButton = Driver.getDriver().findElement(By.xpath("(//button[@accesskey])[1]"));
        createButton.click();

        WebElement okButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary']"));
        okButton.click();

        Assert.assertTrue(inventoryAdjustment.isDisplayed(),"Inventory Adjustment is not displayed");
    }

    @Test
    public void inventoryManagement(){
        WebElement warehouseManagement= Driver.getDriver().findElement(By.linkText("Warehouse Management"));
        warehouseManagement.click();

        WebElement operationTypesTab= Driver.getDriver().findElement(By.xpath("(//span[@class='oe_menu_text'])[29]"));
        operationTypesTab.click();

        WebElement createButton = Driver.getDriver().findElement(By.xpath("//button[@accesskey='c']"));
        createButton.click();

        Faker faker = new Faker();
        String myString= faker.food().ingredient()  ;

        WebElement operationTypeName= Driver.getDriver().findElement(By.xpath("//input[@class='o_field_char o_field_widget o_input o_required_modifier']"));
        operationTypeName.sendKeys(myString);

        Faker faker1 = new Faker();
        String myString1 = Faker.instance().numerify("12345");
        WebElement referenceSeq = Driver.getDriver().findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[1]"));
        referenceSeq.sendKeys(myString1);

        WebElement typeOfOperationTab= Driver.getDriver().findElement(By.xpath("//select[@class='o_input o_field_widget o_required_modifier']"));
        typeOfOperationTab.click();


        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='o_input o_field_widget o_required_modifier']")));
        select.selectByIndex(1);

        WebElement operationReturnType= Driver.getDriver().findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[3]"));
        operationReturnType.click();

//            Select select1 = new Select(Driver.getDriver().findElement(By.xpath("(//li[@class='ui-menu-item'])[1]")));
//            select1.selectByIndex(1);
        // Driver.getDriver().findElement(By.xpath("(//*[@class = 'o_input ui-autocomplete-input'])[3]")).click();

        Driver.getDriver().findElement(By.linkText("YourCompany: 7yy")).click();


        WebElement showDetailedOperations = Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[3]"));
        showDetailedOperations.click();

        WebElement  showReserved = Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[4]"));
        showReserved.click();

        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//button[@accesskey='s']"));
        saveButton.click();

        WebElement assertion = Driver.getDriver().findElement(By.xpath("//ol[@class='breadcrumb']"));

        Assert.assertTrue(assertion.isDisplayed(),"Verification for All Operattions has not dispalayed");

    }


//    AZAMAT
    @Test
    public void createProductCategories(){
        WebElement products = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=351&action=']"));
        products.click();
        WebElement productCategories = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=354&action=232']"));
        productCategories.click();

        WebElement createButton = Driver.getDriver().findElement(By.xpath("(//div[@class='o_list_buttons']//button)[1]"));
        createButton.click();

        WebElement inputCategoryName = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        inputCategoryName.sendKeys("productName");

        WebElement parentInventory = Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[5]"));
        parentInventory.click();
        Driver.getDriver().findElement(By.xpath("//li[.='All']")).click();
        WebElement forceRemoval = Driver.getDriver().findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[3]"));
        forceRemoval.click();
        Driver.getDriver().findElement(By.xpath("//li[.='First In First Out (FIFO)']")).click();

        WebElement costingMethod = Driver.getDriver().findElement(By.xpath("//select[@name='property_cost_method']"));
        Select costingMethodDropdown = new Select(costingMethod);
        costingMethodDropdown.selectByIndex(3);

        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_save']"));
        saveButton.click();

        WebElement productHeader = Driver.getDriver().findElement(By.xpath("//span[@class='o_field_char o_field_widget o_required_modifier']"));

        Assert.assertEquals(productHeader.getText(), "productName");

    }

    @Test
    public void discardScrapOrdersCreation(){
        WebElement scrap = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=369&action=501']"));
        scrap.click();

        WebElement createButton = Driver.getDriver().findElement(By.xpath("//div[@class='o_list_buttons']/button[1]"));
        createButton.click();

        WebElement discardButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-sm o_form_button_cancel']"));
        discardButton.click();
        WebElement scrapOrdersHeader = Driver.getDriver().findElement(By.xpath("//ol[@class='breadcrumb']"));

        Assert.assertTrue(scrapOrdersHeader.isEnabled(), "Discard button is not clickable!");
    }


//    AZIZA
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


//    TUGBA
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


//CHOLPON
    @Test
    public void firstMethod() throws InterruptedException{
    WebElement products = Driver.getDriver().findElement(By.linkText("Products"));
    products.click();
    Thread.sleep(2000);
    WebElement createButton = Driver.getDriver().findElement(By.xpath("//div[@class='o_cp_buttons']//div[1]//button[1]"));
    createButton.click();
    WebElement purchaseTab = Driver.getDriver().findElement(By.linkText("Purchase"));
    purchaseTab.click();
    WebElement findAnItemTab = Driver.getDriver().findElement(By.linkText("Add an item"));
    findAnItemTab.click();
    WebElement vendorTab = Driver.getDriver().findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[22]"));
    vendorTab.sendKeys("Anything"+ Keys.TAB);
    WebElement productName = Driver.getDriver().findElement(By.xpath("//input[@name='product_name']"));
    productName.click();
    WebElement productCode = Driver.getDriver().findElement(By.xpath("//input[@name='product_code']"));
    productCode.click();
    WebElement deliveryLeadTime = Driver.getDriver().findElement(By.xpath("//input[@name='delay']"));
    deliveryLeadTime.click();
    WebElement minimalQuantity = Driver.getDriver().findElement(By.xpath("//input[@name='min_qty']"));
    minimalQuantity.click();
    WebElement priceField = Driver.getDriver().findElement(By.xpath("//input[@name='price']"));
    priceField.click();
    WebElement validityStartDate = Driver.getDriver().findElement(By.xpath("//input[@name='date_start']"));
    validityStartDate.sendKeys("01-01-2019");
    validityStartDate.click();
    WebElement vaidityEndDate = Driver.getDriver().findElement(By.xpath("//input[@name='date_end']"));
    vaidityEndDate.sendKeys("01-30-2019");
    vaidityEndDate.click();
    WebElement saveAndClose = Driver.getDriver().findElement(By.xpath("//div[@class='modal-footer']/button[1]"));
    saveAndClose.click();
    WebElement discard = Driver.getDriver().findElement(By.xpath("//div[@class='modal-footer']//button[3]//span"));
    discard.click();
    Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://54.148.96.210/web?#id=&view_type=form&model=product.template&menu_id=378&action=521", "Discard Button verification is Not Passes");
}

    @Test
    public void SmokeSuite255() {
        WebElement inventoryValuation = Driver.getDriver().findElement(By.linkText("Inventory Valuation"));
        inventoryValuation.click();
        WebElement retriveButton = Driver.getDriver().findElement(By.xpath("//button[@name='open_table']/span"));
        retriveButton.click();
        WebElement searchBox = Driver.getDriver().findElement(By.className("o_searchview_input"));
        searchBox.sendKeys("ice cream" + Keys.ENTER);
        WebElement a = Driver.getDriver().findElement(By.className("ui-sortable"));
        Assert.assertTrue(a.isDisplayed());
    }
}
