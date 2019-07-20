package tests;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.Config;
import utilites.Driver;
import utilites.TestBase;


import java.util.concurrent.TimeUnit;
public class Aisuluu extends TestBase {

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

}
