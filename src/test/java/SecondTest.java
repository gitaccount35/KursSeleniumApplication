import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest {

    @Test
    public void findSeleniumTutorial() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("http://seleniumdemo.com");

        driver.findElement(By.xpath("//span[text()='Shop'][@class='nav__title']")).click();

        WebElement Product = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));

        Assert.assertTrue(Product.isDisplayed());

        Thread.sleep(5000);

        driver.quit();


    }
}
