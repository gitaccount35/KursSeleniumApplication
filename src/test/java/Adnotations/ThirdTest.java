package Adnotations;

import org.testng.annotations.Test;

public class ThirdTest {

    @Test (priority=0)
    public void PierwszyTest()
    {
        System.out.println("PierwszyTest");
    }

    @Test (priority=2)
    public void DrugiTest()
    {
        System.out.println("DrugiTest");
    }

    @Test(priority = 1)
    public void TrzeciTest()
    {
        System.out.println("TrzeciTest");
    }

}
