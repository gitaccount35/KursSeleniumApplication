import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {


    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

    }

    @Test
    public static void SampleTest(){

        System.out.println("Hello World!");
    }



}
