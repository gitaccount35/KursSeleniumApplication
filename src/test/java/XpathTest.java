import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class XpathTest {


    @Test
    public void findElements() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement fullpath = driver.findElement(By.xpath("/html/body/div/ul"));
        WebElement shortpath = driver.findElement(By.xpath("//ul"));

        WebElement clickon= driver.findElement(By.xpath("//button[@id='clickOnMe']"));
        WebElement fname = driver.findElement(By.xpath("//input[@name='fname']"));

        WebElement topSecret = driver.findElement(By.xpath("//p[@class='topSecret']"));

        WebElement input = driver.findElement(By.xpath("//input"));
        input.sendKeys("Pierwszy");
        //jak znajduje kilka elementów w zapytaniu - kilka inputów to findElement zwraca pierwszy na liście

        WebElement link=driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        WebElement partiallink= driver.findElement(By.xpath("//a[contains(text(),'Visit')]"));

        WebElement all=driver.findElement(By.xpath("//*"));
        WebElement secondElem=driver.findElement(By.xpath("(//input)[2]"));
        WebElement lastElem=driver.findElement(By.xpath("(//input)[last()]"));
        WebElement elemwithAttrib=driver.findElement(By.xpath("//*[@name]"));

        WebElement attrequal=driver.findElement(By.xpath("//button[@id='clickOnMe']"));
        WebElement attnotrequal=driver.findElement(By.xpath("//*[@id!='clickOnMe']"));
        WebElement attrcont=driver.findElement(By.xpath("//*[contains(@name, 'ame')]"));
        WebElement startswith=driver.findElement(By.xpath("//*[starts-with(@name, 'user')]"));
        //WebElement endsswith=driver.findElement(By.xpath("//*[ends-with(@name, 'name']"));
        WebElement endswith2=driver.findElement(By.xpath("//*[substring(@name,string-length(@name)-string-length('name')+1)='name']"));

        //dzieci
        WebElement child=driver.findElement(By.xpath("//div/child::ul"));
        //zstępni - dzieci i wnuki
        WebElement desc=driver.findElement(By.xpath("//div/descendant::ul"));
        //rodzic
        WebElement parent=driver.findElement(By.xpath("//div/.."));
        //wstepni - rodzice dziadkowie
        WebElement ances=driver.findElement(By.xpath("//div/ancestor::*"));
        //elementy za tagiem
        WebElement foll=driver.findElement(By.xpath("//img/following::*"));
        //elementy za tagiem na tym samym poziomie
        WebElement follsib=driver.findElement(By.xpath("//img/following-sibling::*"));
        //elementy przed tagiem
        WebElement preced=driver.findElement(By.xpath("//img/preceding::*"));
        //elementy przed tagiem na tym samym poziomie
        WebElement precedsib=driver.findElement(By.xpath("//img/preceding-sibling::*"));

        WebElement divandlink=driver.findElement(By.xpath("//div | //a"));
        WebElement andop=driver.findElement(By.xpath("//input[@name='fname' and @id='fname']"));
        WebElement orop=driver.findElement(By.xpath("//input[@name='fname' or @id='fnam']"));








        Thread.sleep(3000);
        driver.quit();


    }

}