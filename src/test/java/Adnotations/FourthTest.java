package Adnotations;

import org.testng.annotations.Test;

public class FourthTest {

    @Test (dependsOnMethods = "TrzeciTest")
    public void PierwszyTest()
    {
        System.out.println("PierwszyTest");
    }

    @Test (dependsOnMethods ="PierwszyTest" )
    public void DrugiTest()
    {
        System.out.println("DrugiTest");
    }

    @Test
    public void TrzeciTest()
    {
        System.out.println("TrzeciTest");
    }

}
