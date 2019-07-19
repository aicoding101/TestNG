package utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver extends SAD{

    private static WebDriver driver;

//    public static void setDriver() {
//        if(Config.getProperty("browser").equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//
//        } else {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            SAD.setDriver(driver);
//        }
//
//        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//    }

//    public static WebDriver getDriver(){
//        if (driver == null){
//            switch (Config.getProperty("browser")){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                default:
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//            }
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }
}




