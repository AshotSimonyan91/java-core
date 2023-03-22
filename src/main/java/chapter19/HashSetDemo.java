package chapter19;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("betta");
        hs.add("alfa");
        hs.add("etta");
        hs.add("gamma");
        hs.add("epsilon");
        hs.add("omega");

        System.out.println(hs);
    }
}
