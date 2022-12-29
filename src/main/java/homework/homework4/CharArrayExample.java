package homework.homework4;

public class CharArrayExample {
    public static void main(String[] args) {

        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        char[] chars2 = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        char[] chars3 = {'j', 'a', 'v', 'a', 'l', 'o', 'l', 'y'};
        char[] text = {' ', ' ', 'b', 'a', 'r', 'e', 'v', ' ', ' '};

        char c = 'o';
        int counter = 0;
        for (char x:chars) {
            if (c == x) {
                counter++;
            }
        }
        System.out.println("1)c փոփոխականից chars մասիվում կա՝ " + counter + " հատ");
        System.out.println("2)chars2 մասիվի մեջտեղի երկու սինվոլներն են՝ " + chars2[(chars2.length / 2) - 1] +", "+ chars2[chars2.length / 2]);
        System.out.print("3)chars3 մասիվը վեռջանում է արդյոք <<ly>>-ով? ");
        System.out.println(chars3[chars3.length - 2] == 'l' && chars3[chars3.length - 1] == 'y');


        System.out.print("4)տպում ենք text մասիվի այն անդամները որոնք բացատի սինվոլից տարբեր են՝ ");
        for (char x:text) {
            if (x != ' '){
                System.out.print(x + " ");
            }
        }
    }
}
