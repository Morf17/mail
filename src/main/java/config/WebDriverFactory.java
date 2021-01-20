package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null){
            driver = createDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver createDriver() {
        setChromeDriverBin();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(TestConfig.IMPLICITLY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
         return webDriver;
    }

    private static void setChromeDriverBin(){
        WebDriverManager.chromedriver().clearPreferences().setup();
        System.setProperty("webdriver.chrome.driver", WebDriverManager.chromedriver().getBinaryPath());
    }
}
