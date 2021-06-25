class Solution {
    public boolean rotateString(String A, String B) {
        HashMap<String,Boolean> map = new HashMap<>();
        
        if(A.equals(B)){
            return true;
        }
        
        for(int i = 0; i < A.length(); i++){
            map.put(A.substring(i + 1, A.length()) + A.substring(0, i + 1), true);
        }
        
        if(map.containsKey(B)){
            return true;
        }else{
            return false;
        }
    }
}
