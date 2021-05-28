class Solution {
    public String freqAlphabets(String s) {
        HashMap<String,String> map = new HashMap<>();
        
        String codes[] = {"a","1","b","2","c","3","d","4","e","5","f","6","g","7","h","8","i","9","j","10","k","11","l","12","m","13","n","14","o","15","p","16","q","17","r","18","s","19","t","20","u","21","v","22","w","23","x","24","y","25","z","26"};
        
        for(int i = 0; i < codes.length; i = i + 2){
            map.put(codes[i + 1],codes[i]);
        }
        
        int i = 0;
        String ans = "";
        
        while(i < s.length()){
            if(i + 2 < s.length() && s.charAt(i + 2) == '#'){
                String curr = s.substring(i,i + 2);
                ans += map.get(curr);
                i = i + 3;
            }else{
                String curr = s.substring(i,i + 1);
                ans += map.get(curr);
                i = i + 1;
            }
        }
        
        return ans;
    }
}
