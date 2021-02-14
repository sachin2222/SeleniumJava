package Collections.Assignment;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment {


    @Test
    void test1() {

        int a[] = {1, 1, 2, 1, 1, 2, 3, 4, 5, 6, 1, 7, 8, 8, 0}; //--> 1,2

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int count = 1;

            if (!list.contains(a[i])) {

                list.add(a[i]);
                for (int j = i + 1; j < a.length; j++) {

                    if (a[i] == a[j]) {
                        count++;

                    }


                }
                System.out.println("Frequency of " + a[i] + " is " + count);

            }


        }


        System.out.println(list);

    }


    @Test
    void test2() {

        int a[] = {1, 2, 2, 3, 3, 3, 1, 2, 3}; //--> 1,2,3
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < a.length; i++) {

            if (!list.contains(a[i])) {

                list.add(a[i]);
            }


        }


        System.out.println(list);


    }


    @Test
    void hashMapTest() {

        int a[] = {1, 2, 2, 3, 3, 3, 1, 2, 3};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int count = 1;

            map.put(count, a[i]);


        }


    }


    @Test
    void sortArray() {

        int a[] = {1, 2, 34, 5, 5, 5, 1, 2, 0};
        List<Integer> list = new ArrayList<>();

        for (int Value : a) {
            list.add(Value);

        }

        System.out.println(list);
        List<Integer> sortedList = list.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedList);


    }

    @Test
    public void reverseString() {

        // String a="sachin is Good";
        //Stream.of(a).map(s->new StringBuilder(s).reverse().toString()).forEach(s-> System.out.println(s));

       // int a[] = {1, 2, 3, 4, 5,-1,-3,10};
        //Arrays.stream(a).sorted().forEach(s-> System.out.println(s));

        char ch[]={'a','b','z','a'};

       // new String(ch).chars().mapToObj(i->(char)i).sorted().distinct().forEach(s-> System.out.println(s));

        String s="india";
        System.out.println(new StringBuilder(s).delete(0,1).toString());



    }
}
