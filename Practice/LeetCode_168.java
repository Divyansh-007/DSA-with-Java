class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        
        while(columnNumber > 0){
            ans = (char)('A' + ((columnNumber - 1) % 26)) + ans;
            columnNumber = (columnNumber - 1) / 26;
        }
        
        return ans;
    }
}
