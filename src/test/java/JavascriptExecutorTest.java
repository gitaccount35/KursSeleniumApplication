import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JavascriptExecutorTest
{
    @Test
    public void ExecuteJavascript() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium");
        WebElement strona=driver.findElement(By.partialLinkText("Podstawowa"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", strona);

        WebElement firstname=driver.findElement(By.name("fname"));
        executor.executeScript("arguments[0].setAttribute('value', 'Piotr');", firstname);

        Thread.sleep(3000);
        driver.quit();


    }


}
