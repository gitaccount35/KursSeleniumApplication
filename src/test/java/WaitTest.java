import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitTest {

    @Test
    public void Wait() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        // dla wszystkich elementow na stronie czeka 10s:
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        WebElement button=driver.findElement(By.id("clickOnMe"));
        button.click();
        //Thread.sleep(5000);

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("p")));

       // driver.findElement(By.cssSelector("p"));

        //Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void FluentWait(){

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        WebElement button=driver.findElement(By.id("clickOnMe"));
        button.click();
        //Thread.sleep(5000);

        FluentWait<WebDriver> wait= new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));  //sprawdza co 1s
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("p")));

        // driver.findElement(By.cssSelector("p"));

        //Thread.sleep(3000);
        driver.quit();

    }



}
