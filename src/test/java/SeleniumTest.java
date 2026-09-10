import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class SeleniumTest {


    @Test
    public static void OpenGoogleSite() throws InterruptedException {


        WebDriver driver = getDriver("edge");

        driver.manage().window().maximize();
        driver.get("https://www.bing.com");
        Thread.sleep(5000);
        WebElement agreebutton = driver.findElement(By.xpath("//a[text()='Akceptuj']"));
        agreebutton.click();
        Thread.sleep(3000);

        WebElement searchfield = driver.findElement(By.name("q"));
        searchfield.sendKeys("Selenium");
        searchfield.sendKeys(Keys.ENTER);

        WebElement result= driver.findElement(By.xpath("//p[contains(normalize-space(.), 'Selenium automates browsers')][@class='b_lineclamp2']"));

            //cite[text()='https://www.selenium.dev']
        Assert.assertTrue(result.isDisplayed());

        Thread.sleep(5000);
        driver.quit();

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