import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClickTest {

    @Test
    public void RightClick() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        Thread.sleep(3000);
        driver.quit();

    }
    @Test
    public void DoubleClick() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();
        Thread.sleep(3000);
        driver.quit();
    }

}
