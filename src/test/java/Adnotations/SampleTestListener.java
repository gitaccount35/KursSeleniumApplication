package Adnotations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class SampleTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("I am starting test");

    }

    @Override
    public void onTestSuccess(ITestResult result) {}

    public void onTestFailure(ITestResult result) {
        int randomNumber=(int)(Math.random()*10000);
        System.out.println("I am taking screenshot");

        WebDriver driver=DriverFactory.getDriver();

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        String filename= "failure" + "screenshot-" + randomNumber + ".png";
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        Path targetPath = Path.of("src", "test", "resources", filename);

        try {
            Files.createDirectories(targetPath.getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.copy(
                    sourceFile.toPath(),
                    targetPath,
                    StandardCopyOption.REPLACE_EXISTING
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void onTestSkipped(ITestResult result) {}

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

}
