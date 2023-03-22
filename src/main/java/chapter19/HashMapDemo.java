package chapter19;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Double> hm = new HashMap<>();

        hm.put("Jon Dou", 3434.34);
        hm.put("Tom Smith", 123.22);
        hm.put("Jain Baker", 1378.00);
        hm.put("Tod Hol", 99.22);
        hm.put("Ralf Smith", -19.08);

        Set<Map.Entry<String, Double>> set = hm.entrySet();

        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        double balance = hm.get("Jon Dou");
        hm.put("Jon Dou",balance + 1000);
        System.out.println(hm.get("Jon Dou"));
    }
}
