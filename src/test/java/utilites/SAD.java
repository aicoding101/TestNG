package utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class SAD {


    private static WebDriver driver;
    private static WebElement element;
    private static Select selected;
    private static Actions action;
    private static Alert alert;
    private static String mainHandle;

//    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
//    SET/GET/QUIT DRIVER

    public static void setDriver(WebDriver driverOther) {
        driver = driverOther;
    }

    /*
            getDriver method is called to
            -> first: set up the driver based on information provided from the configuration.properties
            -> second: used to get access to the Webdriver driver instance variable in any class
    */

    public static WebDriver getDriver() {
        if(driver == null) {
            switch (Config.getProperty("browser")) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            WaitTime(12);
            MaximizeWindow();
        }
        return driver;
    }

    // quitDriver method will close all instances of the driver

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
    public static void SetChromeDriver(String link) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(link);
        driver.manage().window().maximize();
        WaitTime(10);
    }

    public static void SetGeckoDriver(String link){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(link);
        driver.manage().window().maximize();
        WaitTime(10);
    }



//    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
//    SIMPLE METHODS

    //    Takes in number of seconds to implicitly wait
    public static void WaitTime(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void PageLoadWaitTime(int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    //    Maximizes current browser window
    public static void MaximizeWindow(){
        driver.manage().window().maximize();
    }

    //    Navigates to the page of the given link
    public static void NavigateToPage(String link){
        driver.navigate().to(link);
    }

    //    Creates an alert
    public static void CreateAlert(){
        setAlert(driver.switchTo().alert());
    }

    //    Creates a window handle
    public static void CreateMainHandle() {
        setMainHandle(driver.getWindowHandle());
    }

    //    Switches window to given handle
    public static void SwitchWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public static void Forward(){
        driver.navigate().forward();
    }

    public static void Back(){
        driver.navigate().back();
    }

//    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
//    GENERAL

//    LEGEND:
//    locator: choose locator type (eg. name, id, xpath, etc.)
//    value: value of element based on locator (eg. locator name: element "some name")
//    send: value to be sent to input box (eg. locator id: element "some id", send "some text you want to input")

    //    Find element (clickable field/link) in page and click
//    Can also be used to click on random text (when you want to click away from a certain field)
    public static void FindAndClick(Locators locator, String value){
        switch (locator){
            case xpath:
                driver.findElement(By.xpath(value)).click();
                break;
            case id:
                driver.findElement(By.id(value)).click();
                break;
            case name:
                driver.findElement(By.name(value)).click();
                break;
            case cssSelector:
                driver.findElement(By.cssSelector(value)).click();
                break;
            case tagName:
                driver.findElement(By.tagName(value)).click();
                break;
            case parcialLinkText:
                driver.findElement(By.partialLinkText(value)).click();
                break;
            case className:
                driver.findElement(By.className(value)).click();
                break;
            case linkText:
                driver.findElement(By.linkText(value)).click();
                break;
        }
    }

    //    Find element (text box) in a page and send given keys
    public static void FindAndSendKeys(Locators locator, String value, String send){
        switch (locator){
            case xpath:
                driver.findElement(By.xpath(value)).sendKeys(send);
                break;
            case id:
                driver.findElement(By.id(value)).sendKeys(send);
                break;
            case name:
                driver.findElement(By.name(value)).sendKeys(send);
                break;
            case cssSelector:
                driver.findElement(By.cssSelector(value)).sendKeys(send);
                break;
            case tagName:
                driver.findElement(By.tagName(value)).sendKeys(send);
                break;
            case parcialLinkText:
                driver.findElement(By.partialLinkText(value)).sendKeys(send);
                break;
            case className:
                driver.findElement(By.className(value)).sendKeys(send);
                break;
            case linkText:
                driver.findElement(By.linkText(value)).sendKeys(send);
                break;
        }
    }

    //    Find element (text box) in a page and send given keys, then enter
    public static void FindAndSendKeysENTER(Locators locator, String value, String send){
        switch (locator){
            case xpath:
                driver.findElement(By.xpath(value)).sendKeys(send + Keys.ENTER);
                break;
            case id:
                driver.findElement(By.id(value)).sendKeys(send + Keys.ENTER);
                break;
            case name:
                driver.findElement(By.name(value)).sendKeys(send + Keys.ENTER);
                break;
            case cssSelector:
                driver.findElement(By.cssSelector(value)).sendKeys(send + Keys.ENTER);
                break;
            case tagName:
                driver.findElement(By.tagName(value)).sendKeys(send + Keys.ENTER);
                break;
            case parcialLinkText:
                driver.findElement(By.partialLinkText(value)).sendKeys(send + Keys.ENTER);
                break;
            case className:
                driver.findElement(By.className(value)).sendKeys(send + Keys.ENTER);
                break;
            case linkText:
                driver.findElement(By.linkText(value)).sendKeys(send + Keys.ENTER);
                break;
        }
    }

    //    Find element on a page and check if it is displayed
    public static boolean FindAndDisplay(Locators locator, String value) {
        switch (locator){
            case xpath:
                return driver.findElement(By.xpath(value)).isDisplayed();
            case id:
                return driver.findElement(By.id(value)).isDisplayed();
            case name:
                return driver.findElement(By.name(value)).isDisplayed();
            case cssSelector:
                return driver.findElement(By.cssSelector(value)).isDisplayed();
            case tagName:
                return driver.findElement(By.tagName(value)).isDisplayed();
            case parcialLinkText:
                return driver.findElement(By.partialLinkText(value)).isDisplayed();
            case className:
                return driver.findElement(By.className(value)).isDisplayed();
            case linkText:
                return driver.findElement(By.linkText(value)).isDisplayed();
        }
        return false;
    }

    //    Clears text from given textbox element
    public static void ClearField(Locators locator, String value){
        switch (locator){
            case xpath:
                driver.findElement(By.xpath(value)).clear();
                break;
            case id:
                driver.findElement(By.id(value)).clear();
                break;
            case name:
                driver.findElement(By.name(value)).clear();
                break;
            case cssSelector:
                driver.findElement(By.cssSelector(value)).clear();
                break;
            case tagName:
                driver.findElement(By.tagName(value)).clear();
                break;
            case parcialLinkText:
                driver.findElement(By.partialLinkText(value)).clear();
                break;
            case className:
                driver.findElement(By.className(value)).clear();
                break;
            case linkText:
                driver.findElement(By.linkText(value)).clear();
                break;
        }
    }

    //    Compare element text with given text
    public static boolean CompareText(Locators locator, String value, String compare){
        switch (locator){
            case xpath:
                return driver.findElement(By.xpath(value)).getText().contains(compare);
            case id:
                return driver.findElement(By.id(value)).getText().contains(compare);
            case name:
                return driver.findElement(By.name(value)).getText().contains(compare);
            case cssSelector:
                return driver.findElement(By.cssSelector(value)).getText().contains(compare);
            case tagName:
                return driver.findElement(By.tagName(value)).getText().contains(compare);
            case parcialLinkText:
                return driver.findElement(By.partialLinkText(value)).getText().contains(compare);
            case className:
                return driver.findElement(By.className(value)).getText().contains(compare);
            case linkText:
                return driver.findElement(By.linkText(value)).getText().contains(compare);
        }
        return false;
    }

    //    Takes an integer of pixels to determine the range scrolled within a page (scrolls down)
    public static void ScrollPage(int pixels){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(pixels > 0){
            js.executeScript("window.scrollBy(0," + pixels + ")");
        }else{
            js.executeScript("window.scrollBy(0," + Integer.MAX_VALUE + ")");
        }
    }

    //    Returns a web element of the values passed in the parameter
    public static WebElement GetWebElement(Locators locator, String value){
        switch (locator){
            case xpath:
                setElement(driver.findElement(By.xpath(value)));
                break;
            case id:
                setElement(driver.findElement(By.id(value)));
                break;
            case name:
                setElement(driver.findElement(By.name(value)));
                break;
            case cssSelector:
                setElement(driver.findElement(By.cssSelector(value)));
                break;
            case tagName:
                setElement(driver.findElement(By.tagName(value)));
                break;
            case parcialLinkText:
                setElement(driver.findElement(By.partialLinkText(value)));
                break;
            case className:
                setElement(driver.findElement(By.className(value)));
                break;
            case linkText:
                setElement(driver.findElement(By.linkText(value)));
                break;
        }
        return getElement();
    }

//    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
//    GENERAL USING INSTANCE VARIABLES

    //    Scroll to given element
    public static void ScrollToElement(Locators locator, String value){
        switch (locator){
            case xpath:
                setElement(driver.findElement(By.xpath(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
            case id:
                setElement(driver.findElement(By.id(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
            case name:
                setElement(driver.findElement(By.name(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
            case cssSelector:
                setElement(driver.findElement(By.cssSelector(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
            case tagName:
                setElement(driver.findElement(By.tagName(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
            case parcialLinkText:
                setElement(driver.findElement(By.partialLinkText(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
            case className:
                setElement(driver.findElement(By.className(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
            case linkText:
                setElement(driver.findElement(By.linkText(value)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getElement());
                break;
        }
    }

    //    Creates a select object
    public static void CreateSelectObject(Locators locator, String value){
        switch (locator){
            case xpath:
                setSelected(new Select(driver.findElement(By.xpath(value))));
                break;
            case id:
                setSelected(new Select(driver.findElement(By.id(value))));
                break;
            case name:
                setSelected(new Select(driver.findElement(By.name(value))));
                break;
            case cssSelector:
                setSelected(new Select(driver.findElement(By.cssSelector(value))));
                break;
            case tagName:
                setSelected(new Select(driver.findElement(By.tagName(value))));
                break;
            case parcialLinkText:
                setSelected(new Select(driver.findElement(By.partialLinkText(value))));
                break;
            case className:
                setSelected(new Select(driver.findElement(By.className(value))));
                break;
            case linkText:
                setSelected(new Select(driver.findElement(By.linkText(value))));
                break;
        }
    }

    //    Moves cursor to given element (hover over)
    public static void MoveToElement(Locators locator, String value){
        WebElement web = null;
        switch (locator){
            case xpath:
                web = driver.findElement(By.xpath(value));
                getAction().moveToElement(web).perform();
                break;
            case id:
                web = driver.findElement(By.id(value));
                getAction().moveToElement(web).perform();
                break;
            case name:
                web = driver.findElement(By.name(value));
                getAction().moveToElement(web).perform();
                break;
            case cssSelector:
                web = driver.findElement(By.cssSelector(value));
                getAction().moveToElement(web).perform();
                break;
            case tagName:
                web = driver.findElement(By.tagName(value));
                getAction().moveToElement(web).perform();
                break;
            case parcialLinkText:
                web = driver.findElement(By.partialLinkText(value));
                getAction().moveToElement(web).perform();
                break;
            case className:
                web = driver.findElement(By.className(value));
                getAction().moveToElement(web).perform();
                break;
            case linkText:
                web = driver.findElement(By.linkText(value));
                getAction().moveToElement(web).perform();
                break;
        }
    }

//    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
//    FINISHERS

    //    THAT'S IT!
    public  static void ThatsIt(){ driver.close(); }
    //    DONE!
    public  static void Done(){
        driver.quit();
    }

//    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
//    GETTERS & SETTERS

    public static WebElement getElement() {
        return element;
    }

    public static void setElement(WebElement element) {
        SAD.element = element;
    }

    public static Select getSelected() {
        return selected;
    }

    public static void setSelected(Select selected) {
        SAD.selected = selected;
    }

    public static Actions getAction() {
        return action;
    }

    public static void setAction(Actions action) {
        SAD.action = action;
    }

    public static Alert getAlert() {
        return alert;
    }

    public static void setAlert(Alert alert) {
        SAD.alert = alert;
    }

    public static String getMainHandle() {
        return mainHandle;
    }

    public static void setMainHandle(String mainHandle) {
        SAD.mainHandle = mainHandle;
    }

}

