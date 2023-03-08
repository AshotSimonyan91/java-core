package chapter9;

public class AskMe implements SharedConstants{
    static void answer(int result){
        switch (result) {
            case NO -> System.out.println("No");
            case YES -> System.out.println("Yes");
            case MAYBE -> System.out.println("Maybe");
            case LATER -> System.out.println("Later");
            case SOON -> System.out.println("Soon");
            case NEVER -> System.out.println("Never");
        }
    }
}
