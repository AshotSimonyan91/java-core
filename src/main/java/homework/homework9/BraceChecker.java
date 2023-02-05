package homework.homework9;

public class BraceChecker {

    private String text;
    private Stack stack = new Stack();

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        int trueChecker = 0;
        int pushCounter = 0;
        int[] arrayPushIndex = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(', '[', '{':
                    stack.push(text.charAt(i));
                    arrayPushIndex[pushCounter++] = i;
                    break;
                case ')', ']', '}':
                    char brace = stack.pop();
                    if ((brace + 2) != text.charAt(i) && (brace + 1) != text.charAt(i)) {
                        if (brace == '0') {
                            System.out.println("Error:Didn't open  but closed " + text.charAt(i) + " at " + i);
                        } else {
                            System.out.println("Error: opened " + brace + " but closed " + text.charAt(i) + " at " + i);
                        }
                        trueChecker++;
                        pushCounter--;
                    }
                    break;
            }
        }
        int index = pushCounter - 1;
        for (int i = 0; i < pushCounter; i++) {
            switch (stack.pop()) {
                case '(':
                    System.out.println("Error: Opened in " + arrayPushIndex[index--] + " index  ( but not closed.");
                    trueChecker++;
                    break;
                case '[':
                    System.out.println("Error: Opened in " + arrayPushIndex[index--] + " index  [ but not closed.");
                    trueChecker++;
                    break;
                case '{':
                    System.out.println("Error: Opened in " + arrayPushIndex[index--] + " index  { but not closed.");
                    trueChecker++;
                    break;
            }
        }
        if (trueChecker == 0) {
            System.out.println("Text is true.");
        }
    }
}
