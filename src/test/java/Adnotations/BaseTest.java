package Adnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

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
    public void afterMethod(){
        System.out.println("After Method");
    }



}
