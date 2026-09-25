package Adnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class SecondTest extends BaseTest{

    WebDriver driver ;


    @Test
    public void pierwszyTest(){
        // jeszcze inny rodzaj waita
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        WebElement button=driver.findElement(By.id("clickOnMe"));
        button.click();
        //Thread.sleep(5000);

        waitforElementtoexist(By.cssSelector("p"));


        driver.quit();

    }
    @Test
    public void drugiTest(){
        // jeszcze inny rodzaj waita
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        WebElement button=driver.findElement(By.id("clickOnMe"));
        button.click();
        //Thread.sleep(5000);

        waitforElementtoexist(By.cssSelector("p"));


        driver.quit();

    }


     public void waitforElementtoexist(By locator){

         FluentWait<WebDriver> wait= new FluentWait<>(driver);
         wait.ignoring(NoSuchElementException.class);
         wait.withTimeout(Duration.ofSeconds(10));
         wait.pollingEvery(Duration.ofSeconds(1));

         wait.until(new Function<WebDriver, Boolean>() {
             @Override
             public Boolean apply(WebDriver driver) {
                 List<WebElement> elements= driver.findElements(locator);
                 if (elements.size()>0){
                     System.out.println("Element jest na stronie");
                    return true;
                    }
                 else {
                     System.out.println("Elementu nie ma na stronie");
                     return false;
                 }
             }
         });

     }

}
