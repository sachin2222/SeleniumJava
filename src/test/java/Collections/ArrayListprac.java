package Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListprac {

    private java.lang.Object Object;

    @Test
    public void test1() {

        ArrayList<String> a = new ArrayList<String>();
        a.add("sachin");
        a.add("Tester");
        a.add(1, "automation");
        a.addAll(a);
        a.remove(3);
        a.remove(a.get(3));
        a.remove(a.get(3));

        //System.out.println(a);
        //System.out.println(a.contains("sachin"));


        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            list.add(i);

        }
        System.out.println(list);
        int x = 5;


        for (int i = x; i < list.size(); i++) {

            list.remove(i);
            i--;
        }

        System.out.println(list);



    }
}
