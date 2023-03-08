package chapter12;

public class AskMe {
    static void answer (Answers result) {
        switch (result) {
            case NO -> System.out.println("no");
            case YES -> System.out.println("yes");
            case MAYBE -> System.out.println("maybe");
            case LATER -> System.out.println("later");
            case SOON -> System.out.println("soon");
            case NEVER -> System.out.println("never");
        }
    }
}
