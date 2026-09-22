import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void NewWindow() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");

        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);
        //driver.switchTo().frame(0);

        driver.findElement(By.name("fname")).sendKeys("tester");

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());


        Thread.sleep(3000);
        driver.quit();


    }


}
