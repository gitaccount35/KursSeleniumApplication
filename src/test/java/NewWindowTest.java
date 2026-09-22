import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

    @Test
    public void WindowTest() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        String currentWindow = driver.getWindowHandle();
        System.out.println("Current Window: " + currentWindow);

        WebElement newwindow=driver.findElement(By.id("newPage"));
        newwindow.click();

        Set<String> windowsNames = driver.getWindowHandles();

        for (String windowName : windowsNames) {
            if (!windowName.equals(currentWindow)) {
                driver.switchTo().window(windowName);
                System.out.println(windowName);
            }
        }
        driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");

        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Piotr");

        //Thread.sleep(3000);
        //driver.quit();

    }

}
