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
        WebElement idelementcss2 = driver.findElement(By.cssSelector("#clickOnMe"));


        WebElement nameelem=driver.findElement(By.name("fname"));
        WebElement nameelemcss=driver.findElement(By.cssSelector("input[name=fname]"));
        WebElement nameelemcss2=driver.findElement(By.cssSelector("[name=fname]"));
        WebElement attcontains=driver.findElement(By.cssSelector("[name*=nam]"));
        WebElement attrstarts=driver.findElement(By.cssSelector("[name^=f]"));
        WebElement attrends=driver.findElement(By.cssSelector("[name$=name]"));


        WebElement classelem=driver.findElement(By.className("topSecret"));
        WebElement classelemcss=driver.findElement(By.cssSelector("p[class=topSecret]"));
        WebElement classelemcss2=driver.findElement(By.cssSelector(".topSecret"));


        WebElement tagelem=driver.findElement(By.tagName("input"));
        WebElement tagelemcss=driver.findElement(By.cssSelector("input"));
        tagelem.sendKeys("Pierwszy");

        List<WebElement> list=driver.findElements(By.tagName("input"));
        System.out.println(list.size());

        WebElement linktext=driver.findElement(By.linkText("Visit W3Schools.com!"));
        WebElement partiallink=driver.findElement(By.partialLinkText("Visit"));

        WebElement ulindiv=driver.findElement(By.cssSelector("div ul"));
        WebElement trintable=driver.findElement(By.cssSelector("table tr"));

        WebElement firstchildUlindiv = driver.findElement(By.cssSelector("div > ul "));
        WebElement firstchildTrinTbody= driver.findElement(By.cssSelector("tbody > tr"));

        WebElement firstformafterlabel= driver.findElement(By.cssSelector("label + form"));
        WebElement allformafterlabel= driver.findElement(By.cssSelector("label ~ form"));

        WebElement firstchild=driver.findElement(By.cssSelector("li:first-child"));
        WebElement lastchild=driver.findElement(By.cssSelector("li:last-child"));
        WebElement thirdchild=driver.findElement(By.cssSelector("li:nth-child(3)"));

        Thread.sleep(5000);
        driver.quit();


    }
}
