package tester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {

        return driver.get();
    }
    @BeforeClass
    public void webLaunch(){
        String location = System.getProperty("user.dir") + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", location);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        driver.set(new ChromeDriver(options));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().get("https://facebook.com");

    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            try {
                getDriver().close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
