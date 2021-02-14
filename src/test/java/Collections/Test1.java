package Collections;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Test1 {


    @Test
    void test1(){

        Arrays.asList(10,1,2,11,6,1,1,1,1,4,5,6,6,6,3,4).stream().sorted().distinct().forEach(s-> System.out.println(s));

    }
}
