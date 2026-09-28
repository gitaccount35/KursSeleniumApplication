package Adnotations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {



    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Before Class");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After Suite");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("After Method");
        WebDriver driver = DriverFactory.getExistingDriver();
        if (driver == null) {
            return;
        }

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS"));
                Path targetPath = Path.of("src", "test", "resources", "failure-screenshot-" + timestamp + ".png");
                Files.createDirectories(targetPath.getParent());
                Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to save failure screenshot", e);
        } finally {
            DriverFactory.quitDriver();
        }
    }



}
