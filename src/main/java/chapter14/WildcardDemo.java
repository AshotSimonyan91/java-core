package chapter14;

public class WildcardDemo {
    public static void main(String[] args) {
        Integer[] inums = {1,2,3,4,5};
        Stats<Integer> iOb = new Stats<>(inums);
        double v = iOb.average();
        System.out.println(v);

        Double[] dnums = {1.1,2.2,3.3,4.4,5.5};
        Stats<Double> dOb = new Stats<>(dnums);
        double w = dOb.average();
        System.out.println(w);

        Float[] fnums = {1.0F,2.0F,3.0F,4.0F,5.0F};
        Stats<Float> fOb = new Stats<>(fnums);
        double x = fOb.average();
        System.out.println(w);


        if (iOb.sameAvg(dOb)){
            System.out.println("equals");
        }else {
            System.out.println("doesn't equals");
        }

        if (iOb.sameAvg(fOb)){
            System.out.println("equals");
        }else {
            System.out.println("doesn't equals");
        }
    }
}
