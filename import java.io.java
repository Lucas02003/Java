import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GroupingSymbolsChecker {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolsChecker <source-file>");
            return;
        }

        String fileName = args[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    } else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if (!isValid) break;
            }
            reader.close();

            if (isValid && stack.isEmpty()) {
                System.out.println("The grouping symbols are correctly matched.");
            } else {
                System.out.println("The grouping symbols are not correctly matched.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }
}