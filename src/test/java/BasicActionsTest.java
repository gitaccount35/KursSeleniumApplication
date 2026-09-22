import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void Actions() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium");
        //WebElement strona=driver.findElement(By.xpath("//a[contains(text(),'Podstawowa')]"));
        WebElement strona=driver.findElement(By.partialLinkText("Podstawowa"));
        strona.click();
        driver.findElement(By.id("fname")).sendKeys("Piotr");

        WebElement puttext= driver.findElement(By.name("username"));
        puttext.clear();
        puttext.sendKeys("admin");

        System.out.println(puttext.getAttribute("value"));
        puttext.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        // tu jest jeszcze drugi alert zaraz po 1szym
        driver.switchTo().alert().accept();

        WebElement checkbox= driver.findElement(By.xpath("//label[contains(text(),'Potwierdzam')]"));
        checkbox.click();

        WebElement Radiob=driver.findElement(By.cssSelector("input[value='male']"));
        Radiob.click();

        WebElement car=driver.findElement(By.cssSelector("select"));
        Select select=new Select(car);
        select.selectByValue("volvo");
        Thread.sleep(2000);
        select.selectByIndex(2);

        List<WebElement> option=select.getOptions();
        for (int i=0;i<option.size();i++){
            System.out.println(option.get(i).getText());
        }

        WebElement hiddenparagr=driver.findElement(By.className("topSecret"));
        System.out.println(hiddenparagr.getAttribute("textContent"));

        Thread.sleep(3000);
        driver.quit();


    }


}
