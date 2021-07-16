class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].isEmpty()){ 
                continue;
            }
            
            sb.append(strs[i]).append(" ");
        }
        
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
