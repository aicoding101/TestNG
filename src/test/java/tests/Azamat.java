package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.Config;
import utilites.Driver;

public class Azamat extends TestBase{

    @Test
    public void createProductCategories(){
//        Driver.getDriver().get(Config.getProperty("url"));
//
//        WebElement login = Driver.getDriver().findElement(By.id("login"));
//        login.sendKeys(Config.getProperty("username"));
//
//        WebElement password = Driver.getDriver().findElement(By.id("password"));
//        password.sendKeys(Config.getProperty("password")+ Keys.ENTER);
//
//        WebElement inventory = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=347&action=']"));
//        inventory.click();

        WebElement products = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=351&action=']"));
        products.click();
        WebElement productCategories = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=354&action=232']"));
        productCategories.click();

        WebElement createButton = Driver.getDriver().findElement(By.xpath("(//div[@class='o_list_buttons']//button)[1]"));
        createButton.click();

        WebElement inputCategoryName = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        inputCategoryName.sendKeys(Config.getProperty("productName"));

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

        Assert.assertEquals(productHeader.getText(), Config.getProperty("productName"));

    }
    @Test
    public void discardScrapOrdersCreation(){
//        Driver.getDriver().get(Config.getProperty("url"));
//
//        WebElement login = Driver.getDriver().findElement(By.id("login"));
//        login.sendKeys(Config.getProperty("userLogin"));
//
//        WebElement password = Driver.getDriver().findElement(By.id("password"));
//        password.sendKeys(Config.getProperty("userPassword")+ Keys.ENTER);
//
//        WebElement inventory = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=347&action=']"));
//        inventory.click();

        WebElement scrap = Driver.getDriver().findElement(By.xpath("//a[@href='/web#menu_id=369&action=501']"));
        scrap.click();

        WebElement createButton = Driver.getDriver().findElement(By.xpath("//div[@class='o_list_buttons']/button[1]"));
        createButton.click();

        WebElement discardButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-sm o_form_button_cancel']"));
        discardButton.click();
        WebElement scrapOrdersHeader = Driver.getDriver().findElement(By.xpath("//ol[@class='breadcrumb']"));

        Assert.assertTrue(scrapOrdersHeader.isEnabled(), "Discard button is not clickable!");




    }

}
