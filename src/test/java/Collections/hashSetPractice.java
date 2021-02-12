package Collections;

import org.testng.annotations.Test;

import java.util.*;

public class hashSetPractice {

    @Test
    void test() {

        List<String> ls = new ArrayList<String>();
        ls.add("USA");
        ls.add("UK");
        ls.add("UK");


        Set<String> hs = new HashSet<String>();
        hs.add("hello");
        hs.add("java");
        hs.addAll(ls);
        System.out.println(hs);
        System.out.println(hs.size());


    }

    @Test
    void hashMap() {

        Map<Integer, String> mp = new HashMap<>();
        mp.put(1, "India");
        mp.put(2, "USA");
        mp.put(1, "sachin");
        mp.put(10, "Cat");
        mp.put(11, "cat");
        System.out.println(mp);

        System.out.println(mp.get(1));
        Set s = mp.entrySet();
        System.out.println(s);

        Iterator it = s.iterator();
        while (it.hasNext()) {

            Map.Entry m = (Map.Entry) it.next();
            System.out.println(m.getValue());
            System.out.println(m.getKey()
            );


        }


    }

    @Test
    void hashTable() {

        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(1, "Cat");
        ht.put(2, "dog");
        ht.put(2,"Rat");
        System.out.println(ht);

        Set s = ht.entrySet();
        Iterator it=s.iterator();

        while(it.hasNext()){

            System.out.println(it.next());

        }



    }

}
