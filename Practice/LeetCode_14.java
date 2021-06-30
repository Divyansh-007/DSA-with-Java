class Solution {
    
    public String lcpHelp(String str1, String str2){
        int min = Math.min(str1.length(),str2.length());
        
        for(int i = 0; i < min; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return str1.substring(0,i);
            }
        }
        
        return str1.substring(0,min);
    }
    
    public String lcp(String[] arr, int si, int ei){
        if(si == ei){
            return arr[si];
        }
        
        int mid = (si + ei) / 2;
        String leftAns = lcp(arr,si,mid - 1);
        String rightAns = lcp(arr,mid + 1,ei);
        
        return lcpHelp(leftAns,rightAns);
    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }
        
        return lcp(strs,0,strs.length - 1);
    }
}
