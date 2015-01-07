import java.util.*;

public class BalancedNesting {

    public static boolean isBalanced(String s) {
        Map<Character, Character> closer2opener = new HashMap<>();
        closer2opener.put(')', '(');
        closer2opener.put(']', '[');
        closer2opener.put('}', '{');
        Collection<Character> openers = closer2opener.values();
        Collection<Character> closers = closer2opener.keySet();
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (openers.contains(c)) {
                // We found an opener, push it onto stack
                stack.push(c);
            } else if (closers.contains(c)) {
                // We found a closer ...
                if (stack.isEmpty()) {
                    // if the stack is empty, there is no associated opener
                    return false;
                }
                Character opener = stack.pop();
                if (!opener.equals(closer2opener.get(c))) {
                    // Most recent opener off stack doesn't match closer
                    return false;
                }
            }
        }
        // If we finish the string with openers still on stack, unbalanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testStrings = {
            "( { [ ] } )", "( { [ } ] )", "} ( { [ ] } )",
            "f(e -> { g(); return a[e]; })",
            "(map (lambda (x) (* x x)) (list 1 2 3 4))",
            "(map (lambda (x) (* x x)) (list 1 2 3 4)))"
        };
        for (String s: testStrings) {
            System.out.printf("%s is balanced: %s.%n", s, isBalanced(s));
        }
    }
}
