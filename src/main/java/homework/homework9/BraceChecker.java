package homework.homework9;

public class BraceChecker {

    private String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        int trueChecker = 0;
        Stack stack = new Stack();
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(', '[', '{':
                    stack.push(text.charAt(i));
                    break;
                case ')', ']', '}':
                    char brace = stack.pop();
                    if ((brace + 2) != text.charAt(i) && (brace + 1) != text.charAt(i)) {
                        System.out.println("Error opened " + brace + " but closed " + text.charAt(i) + " at " + i);
                        trueChecker++;
                    }
                    break;
            }
        }
        if (trueChecker == 0) {
            System.out.println("Text is true.");
        }
    }
}
