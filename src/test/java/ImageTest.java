import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {

    @Test
    public void Image() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");

        WebElement image=driver.findElement(By.tagName("img"));

        String height=image.getAttribute("naturalHeight");

        Assert.assertEquals(height,"0");

        Thread.sleep(3000);
        driver.quit();

    }

}
