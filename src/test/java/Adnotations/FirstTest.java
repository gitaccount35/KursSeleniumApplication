package Adnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class FirstTest extends BaseTest{

    WebDriver driver;

    @Test
    public void pierwszyTest(){
        // jeszcze inny rodzaj waita 
        driver=DriverFactory.getDriver() ;

        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        WebElement button=driver.findElement(By.id("clickOnMe"));
        button.click();
        //Thread.sleep(5000);

        waitforElementtoexist(By.cssSelector("p"));

        WebElement paragr=driver.findElement(By.cssSelector("p"));

        //Assert.assertEquals(paragr.isDisplayed(),"true");
        Assert.assertTrue(paragr.isDisplayed(),"Element is not displayed");
        //Assert.assertEquals(paragr.getText(),"Dopiero","Teksty są różne");
        Assert.assertTrue(paragr.getText().startsWith("Dopiero"));
        Assert.assertFalse(paragr.getText().startsWith("Pojawiłem"));
        Assert.assertEquals(paragr.getText(),"Dopiero się pojawiłem!");

        //driver.quit();

    }
    @Test
    public void drugiTest(){
        // jeszcze inny rodzaj waita
        //WebDriverManager.edgedriver().setup();
        //driver = new EdgeDriver();
        driver=DriverFactory.getDriver() ;

        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        WebElement button=driver.findElement(By.id("clickOnMe"));
        button.click();
        //Thread.sleep(5000);

        waitforElementtoexist(By.cssSelector("p"));

        WebElement paragr=driver.findElement(By.cssSelector("p"));

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(paragr.isDisplayed(),"true");
        softAssert.assertTrue(paragr.isDisplayed(),"Element is not displayed");
        softAssert.assertEquals(paragr.getText(),"Dopiero","Teksty są różne");
        softAssert.assertTrue(paragr.getText().startsWith("Dopiero"));
        softAssert.assertFalse(paragr.getText().startsWith("Pojawiłem"));
        softAssert.assertEquals(paragr.getText(),"Dopiero się", "Druga asercja");

        softAssert.assertAll();

    }


     public void waitforElementtoexist(By locator){

        driver=DriverFactory.getDriver() ;

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
