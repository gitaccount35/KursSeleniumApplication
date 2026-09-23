import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ElementIstnieje {

    WebDriver driver;

    @Test
    public void GetInfo() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(CzyIstnieje(By.tagName("p")));
        System.out.println(CzyIstnieje(By.id("topSecret")));

        System.out.println(CzyIstniejeSecond(By.tagName("p")));
        System.out.println(CzyIstniejeSecond(By.id("topSecret")));

        System.out.println("isDisplayed " + driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println("isDisplayed " + driver.findElement(By.tagName("button")).isDisplayed());
        System.out.println("isEnabled " + driver.findElement(By.tagName("button")).isEnabled());

        WebElement checkbox=driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println("czy checkbox zaznaczony? " + checkbox.isSelected());
        checkbox.click();
        System.out.println("czy checkbox zaznaczony? " + checkbox.isSelected());


        Thread.sleep(3000);
        driver.quit();

    }
    public Boolean CzyIstnieje(By locator){

        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }

    }
    public Boolean CzyIstniejeSecond(By locator){

        return driver.findElements(locator).size()>0;

    }




}
