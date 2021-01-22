import java.util.Stack;

public class Solution {

    public static int countBracketReversals(String input) {
        //Your code goes here
        int len = input.length();
        if(len % 2 != 0) {
            return -1;
        }else {
            Stack<Character> stack = new Stack<>();
            int i = 0;

            while(i < len) {
                if(input.charAt(i) == '{') {
                    stack.push(input.charAt(i));
                }else if(input.charAt(i) == '}') {
                    if(stack.isEmpty()) {
                        stack.push(input.charAt(i));
                    }else if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }else if(!stack.isEmpty() && stack.peek() != '{') {
                        stack.push(input.charAt(i));
                    }
                }
                i = i + 1;
            }

            if(stack.isEmpty()) {
                return 0;
            }

            int count = 0;
            while(!stack.isEmpty()) {
                char c1 = stack.pop();
                char c2 = stack.pop();
                if(c1 == c2) {
                    count = count + 1;
                    continue;
                }else {
                    count = count + 2;
                    continue;
                }
            }

            return count;
        }
    }
}
