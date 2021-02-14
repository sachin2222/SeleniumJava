package Collections.Assignment;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {


    @Test
    public void test1() {

        String s = "NITIN";
        char ch[] = new char[s.length()];
        int i = 0;

        while (i < s.length()) {
            ch[i] = s.charAt(s.length() - 1 - i);

            i++;
        }
        String reverse = new String(ch);

        System.out.println(reverse);

        if (s.equals(reverse)) {

            System.out.println("pallindrome");
        }


    }

    @Test
    public void test2() {
        // Remove  characters whose frequency 2
        String s = "helllh";// h,e,o
        char ch[];
        ch = s.toCharArray();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < ch.length; i++) {
            list.add(ch[i]);

        }
        System.out.println(list);

        List<Character> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);

        for (int i = 0; i < distinctList.size(); i++) {
            int count = 0;

            for (int j = 0; j < list.size(); j++) {

                if (distinctList.get(i).equals(list.get(j))) {
                    count++;

                }
            }
            System.out.println(distinctList.get(i) + " is  " + count);
            int delete = 0;
            if (count == 2) {

                while (delete < count) {

                    list.remove(distinctList.get(i));
                    delete++;
                }


            }


        }
        System.out.println(list);


    }

    @Test
    public void reversewords() {
        String s = "India is my country";
        String[] splitted = s.split(" ");
        String reversedString = "";
        for (int i = 0; i < splitted.length; i++) {

            reversedString = reversedString + reverseString(splitted[i]) + " ";

        }
        System.out.println(reversedString.trim());


    }

    public static String reverseString(String str) {
        char ch[] = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(str.length() - 1 - i);

        }
        String reverse = new String(ch);
        return reverse;


    }

    @Test
    void test5() {

        String s[] = {"india", "is", "my", "country"};
        Iterator<String> it = Arrays.stream(s).iterator();
        String temp = "";

        while (it.hasNext()) {

            temp = temp + it.next() + " ";
        }
        System.out.println(temp.trim());

    }
}