public class Solution {

    public static void printAllPossibleStrings(String input, String outputSoFar) {
        if(input.length() == 0) {
            System.out.println(outputSoFar);
            return;
        }

        char ch = input.charAt(0);
        if(ch == '?') {
            printAllPossibleStrings(input.substring(1), outputSoFar + '0');
            printAllPossibleStrings(input.substring(1), outputSoFar + '1');
        }else {
            printAllPossibleStrings(input.substring(1), outputSoFar + ch);
        }
    }

    public static void printAllPossibleStrings(String str) {
        printAllPossibleStrings(str, "");
    }

}
