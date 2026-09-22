import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class UploadFileTest
{
    @Test
    public void UploadFile() throws InterruptedException, IOException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        int randomNumber=(int)(Math.random()*10000);

        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        driver.findElement(By.id("myFile")).sendKeys("D:\\Programming\\automation\\KursSeleniumApplication\\sample.txt");

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        String filename= "screenshot-" + randomNumber + ".png";
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        Path targetPath = Path.of("src", "test", "resources", filename);

        Files.createDirectories(targetPath.getParent());
        Files.copy(
                sourceFile.toPath(),
                targetPath,
                StandardCopyOption.REPLACE_EXISTING
        );

        Thread.sleep(3000);
        driver.quit();


    }


}
