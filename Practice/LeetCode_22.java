class Solution {
    
    public boolean valid(char[] arr) {
        int balance = 0;
        for (char c: arr) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
    
    public void generateAll(char[] arr, int pos, List<String> result) {
        if (pos == arr.length) {
            if (valid(arr))
                result.add(new String(arr));
        } else {
            arr[pos] = '(';
            generateAll(arr, pos+1, result);
            arr[pos] = ')';
            generateAll(arr, pos+1, result);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateAll(new char[2 * n],0,ans);
        return ans;
    }
}
