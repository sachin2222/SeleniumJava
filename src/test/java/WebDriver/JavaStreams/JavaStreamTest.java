package WebDriver.JavaStreams;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamTest {

    @Test
    public void stream() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("sachin");
        list.add("Ram");
        list.add("suresh");
        list.add("saurabh");

        long count = list.stream().filter(s -> s.startsWith("s")).count();
        // System.out.println(count);

        // Stream.of("Ram,sachin,suresh,kumar").filter(s -> s.startsWith("s")).forEach(s -> System.out.println(s));

        //   list.stream().filter(s -> s.startsWith("s")).forEach(s -> System.out.println(s));

        // list.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
        //ist.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

        Stream.of("Ram", "shyam", "Ghanshyam").forEach(s -> System.out.println(s));


    }


    @Test
    public void mapStream() {
/*
        Stream.of("Ram", "Shyam", "Rahul", "Guru")
                .map(s -> s.toUpperCase(Locale.ROOT))
                .filter(s -> s.endsWith("M"))
                .map(s -> s.toLowerCase(Locale.ROOT))
                .forEach(s -> System.out.println(s));


        String[] array = {"sachin", "ram", "chotu"};
        List<String> list = Arrays.asList(array);
        list.stream().filter(s -> s.startsWith("s")).forEach(s -> System.out.println(s));
*/

//        Stream.of("sachin", "rahul", "kapil", "Lallu", "kumar").sorted().forEach(System.out::println);
        // Stream.of(1,4,3,22,11,45).sorted().forEach(System.out::println);

        Stream<String> s1 = Stream.of("Cat", "Dog", "Parrot");
        Stream<String> s2 = Stream.of("India", "Us", "China");

        boolean b = Stream.concat(s1, s2).sorted().anyMatch(s -> s.startsWith("C"));
        System.out.println(b);

    }


    @Test
    public void streamCollect() {

        List<String> list = new ArrayList<String>();
        list.add("sachin");
        list.add("amar");
        list.add("cat");
        list.add("dog");

        List<String> newlist = list.stream().filter(s -> s.length() > 3).map(s -> s.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());

        //System.out.println(newlist);

        int values[] = {1, 1, 3, 4, 33, 23, 32, 44, 11, 1, 1, 1};

        List<Integer> integerList = Arrays.stream(values).boxed().collect(Collectors.toList());

        // integerList.stream().distinct().sorted().forEach(a-> System.out.println(a));


    }

    @Test
    public void charArayToList() {

        String s1="NITIN";

        char ch[] = s1.toCharArray();

        List<Character> characterList = new ArrayList<Character>();
        for (char c : ch) {
            characterList.add(c);

        }



    }

}