package TestNG;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class Testng2 {



    @Test
    public void carLoan(){
        System.out.println("carLoan");



    }

    @Test
    public void homeLoan(){
        System.out.println("homeLoan");


    }

    @Test
    public void PersonalLoan(){
        System.out.println("PersonalLoan");
        Assert.assertTrue(false);


    }
}
