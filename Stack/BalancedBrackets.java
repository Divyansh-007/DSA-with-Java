import java.util.Stack;

public class Solution {

    public static boolean isBalanced(String expression) {
        //Your code goes here
        //Your code goes here
        Stack<Character> charStack = new Stack<>();

        for(int i = 0; i < expression.length(); i++){
            char bracket = expression.charAt(i);

            if(bracket == '(' || bracket == '[' || bracket == '{'){
                charStack.push(bracket);
                continue;
            }

            if(charStack.isEmpty()){
                return false;
            }else{
                if(bracket == ')'){
                    if(charStack.peek() == '[' || charStack.peek() == '{'){
                        return false;
                    }else{
                        charStack.pop();
                        continue;
                    }
                }else if(bracket == ']'){
                    if(charStack.peek() == '(' || charStack.peek() == '{'){
                        return false;
                    }else{
                        charStack.pop();
                        continue;
                    }
                }else if(bracket == '}'){
                    if(charStack.peek() == '(' || charStack.peek() == '['){
                        return false;
                    }else{
                        charStack.pop();
                        continue;
                    }
                }
            }

        }
        return charStack.isEmpty();
    }
}