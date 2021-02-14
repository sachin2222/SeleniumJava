package TestNG;

import org.junit.Assert;
import org.testng.annotations.*;

public class TestNGPractice {


  /*  @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @BeforeClass
    public void beforeClass(){

        System.out.println("before Class");
    }


    @BeforeTest
    public void beforeTest() {

        System.out.println("beforeTest");
    }

    @BeforeMethod
    public void beforemethod() {

        System.out.println("before Method");
    }

    @AfterMethod
    public void aftermethod() {

        System.out.println("afterMethod");
    }*/


    @Test(dependsOnMethods = {"samsung"}, alwaysRun = true)
    public void test1() {
        System.out.println("Test1");


    }

    @Test(timeOut = 4000)
    public void test2() {
        System.out.println("Test2");


    }

    @Parameters({"URL", "key"})
    @Test(enabled = false)
    public void test3(String url, String key) {
     /*   System.out.println(url);
        System.out.println(key);*/


    }


    @Test(dataProvider = "test4.data")
    public void test4(String str[]) {

        System.out.println(str[0]);
        System.out.println(str[1]);


    }

     @DataProvider(name="test4.data")
     public Object[][] getData(){

       /* String[] s={"india","is","my","country"};
        return s;
        */

         String s[][]={{"sachin","sachin1234"},{"kapil","kapil1234"}};
         return s;


     }



    @Test
    public void samsung() {
        // Assert.assertTrue(false);
        System.out.println("samsung");

    }

   /* @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after Class");
    }


    @AfterSuite
    public void afterSuite(){

        System.out.println("after suite");
    }
*/
}

