package TestNG;

import org.testng.annotations.Test;

public class TestNGFrouptsTest {


    @Test(groups = {"smoke","Regression"})
    public void test1() {

        System.out.println("Test1");
    }

    @Test(groups = {"smoke"})
    public void test2() {
        System.out.println("Test2");

    }

    @Test(groups = {"Regression"})
    public void test3() {
        System.out.println("Test3");

    }
}
