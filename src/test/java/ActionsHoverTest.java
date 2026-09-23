import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsHoverTest {

    @Test
    public void HoverTest() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        Actions actions = new Actions(driver);
        WebElement hover=driver.findElement(By.tagName("h1"));
        actions.moveToElement(hover).perform();

        Thread.sleep(3000);
        driver.quit();

    }

}
