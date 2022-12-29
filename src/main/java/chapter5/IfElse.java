package chapter5;

import org.w3c.dom.ls.LSOutput;

public class IfElse {

    public static void main(String[] args) {
        int month = 4;
        String season;
        if (month == 12 || month == 1 || month == 2) {
            season = "Ձմեռ";
        } else if (month == 3 || month == 4 || month == 5) {
            season = "Գարուն";
        } else if (month == 6 || month == 7 || month == 8) {
            season = "Ամառ";
        } else if (month == 9 || month == 10 || month == 11) {
            season = "Աշուն";
        } else {
            season = "հնարած ամիս";
        }
        System.out.println("Ապրիլը պատկանում է " + season + " շրջանին:");
    }
}
