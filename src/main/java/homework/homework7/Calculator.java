package homework.homework7;

public class Calculator {

    double plus(double numberone, double numbertwo) {
        return numberone + numbertwo;
    }

    double minus(double numberone, double numbertwo) {
        return numberone - numbertwo;
    }

    double divide(double numberone, double numbertwo) {
        if (numbertwo == 0) {
            System.out.println("The number is not divided to 0");
            return -1;
        } else {
            return numberone / numbertwo;
        }
    }

    double multiply(double numberone, double numbertwo) {
        return numberone * numbertwo;
    }
}
