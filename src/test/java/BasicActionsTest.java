import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BasicActionsTest {

    @Test
    public void Actions() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium");
        //WebElement strona=driver.findElement(By.xpath("//a[contains(text(),'Podstawowa')]"));
        WebElement strona=driver.findElement(By.partialLinkText("Podstawowa"));
        strona.click();
        driver.findElement(By.id("fname")).sendKeys("Piotr");

        WebElement puttext= driver.findElement(By.name("username"));
        puttext.clear();
        puttext.sendKeys("admin");
        puttext.sendKeys(Keys.TAB);

        WebElement checkbox= driver.findElement(By.xpath("//label[contains(text(),'Potwierdzam')]"));
        checkbox.click();

        WebElement Radiob=driver.findElement(By.cssSelector("input[value='male']"));
        Radiob.click();

        Thread.sleep(3000);
        driver.quit();


    }


}
