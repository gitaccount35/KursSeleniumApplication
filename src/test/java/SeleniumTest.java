import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Objects;

public class SeleniumTest {


    @Test
    public static void OpenGoogleSite() {


        WebDriver driver = getDriver("edge");

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

    }

    public static WebDriver getDriver(String browserName) {

        switch (browserName) {
            case "edge": {
                System.setProperty("webdriver.edge.driver", "D:\\Programming\\automation\\edgedriver\\msedgedriver.exe");
                return new EdgeDriver();
            }
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", "D:\\Programming\\automation\\firefoxdriver\\geckodriver.exe");
                return new FirefoxDriver();
            }
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "D:\\Programming\\automation\\chromedriver\\chromedriver.exe");
                return new ChromeDriver();
            }
            default:
                throw new IllegalArgumentException("Browser name not found");
        }
    }
}