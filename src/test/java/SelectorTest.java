import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement idelement = driver.findElement(By.id("clickOnMe"));
        WebElement idelementcss = driver.findElement(By.cssSelector("button[id=clickOnMe]"));

        WebElement nameelem=driver.findElement(By.name("fname"));
        WebElement nameelemcss=driver.findElement(By.cssSelector("input[name=fname]"));

        WebElement classelem=driver.findElement(By.className("topSecret"));
        WebElement classelemcss=driver.findElement(By.cssSelector("p[class=topSecret]"));

        WebElement tagelem=driver.findElement(By.tagName("input"));
        WebElement tagelemcss=driver.findElement(By.cssSelector("input"));
        tagelem.sendKeys("Pierwszy");

        List<WebElement> list=driver.findElements(By.tagName("input"));
        System.out.println(list.size());


        Thread.sleep(5000);
        driver.quit();


    }
}
