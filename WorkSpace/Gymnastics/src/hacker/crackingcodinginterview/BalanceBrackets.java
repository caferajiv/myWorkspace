package hacker.crackingcodinginterview;

import java.util.Scanner;
import java.util.Stack;


public class BalanceBrackets
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] data = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            data[i] = in.next();
        } // {[()]} {[(])}
          // String a = "{[(])}";//"{[()]}";//"{{[[(())]]}}";
        for (String a : data) {
            String result = checkIfBracketsBalanced(a);
            System.out.println(result);
        }

    }

    private static String checkIfBracketsBalanced (String a)
    {
        if (a.length() % 2 != 0)
            return "NO";
        char arr[] = a.toCharArray();
        Stack<Character> pushStack = new Stack<>();
        
        for (char c : arr) {
            if (pushStack.isEmpty() && isClosingBracket(c))
                return "NO";
            if (!isClosingBracket(c)) {
                pushStack.push(c);
            }
            else if (isClosingBracket(c)) {
                if (!pushStack.isEmpty() && isBalance(pushStack.pop(), c)) {
                    continue;
                }
                else {
                    return "NO";
                }
            }
        }
        if (pushStack.isEmpty()) {
            return "YES";
        }
        return "NO";

    }

    private static boolean isBalance (char pop, char c)
    {
        return ((c == ')' && pop == '(') || (c == '}' && pop == '{') || (c == ']' && pop == '['));

    }

    private static boolean isClosingBracket (char c)
    {
        return (c == ')' || c == '}' || c == ']');
    }
}