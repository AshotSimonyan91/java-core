package chapter8;

public class RefDemo {
    public static void main(String[] args) {
        BoxWeight boxWeight = new BoxWeight(3,5,7,8.37);
        Box box = new Box();
        double vol;

        vol = boxWeight.volume();
        System.out.println(vol);
        System.out.println(boxWeight.weight);
        System.out.println();

        box = boxWeight;
        vol = box.volume();
        System.out.println(vol);
    }
}
