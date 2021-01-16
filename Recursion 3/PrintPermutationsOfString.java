import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> FindPermutations(String STR) {

        // Write your code here!
        if(STR.length() == 0) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0 ; i < STR.length(); i++) {
            char ch = STR.charAt(i);
            String rem = STR.substring(0, i) + STR.substring(i + 1, STR.length());
            ArrayList<String> smallAns = FindPermutations(rem);
            for(int j = 0; j < smallAns.size(); j++) {
                ans.add(ch + smallAns.get(j));
            }
        }

        return ans;

    }

}
