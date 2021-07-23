class Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        int i = s.length() - 1;
        int count = 0;
        
        while(i >= 0){
            if(chars[i] == '-' && count < k){
                i--;
                continue;
            }
            
            sb.append(Character.toUpperCase(chars[i--]));
            count++;
            
            if(count == k){
                sb.append('-');
                count = 0;
            }
        }
        
        sb.reverse();
        
        if(sb.length() > 0 && sb.charAt(0) == '-'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
