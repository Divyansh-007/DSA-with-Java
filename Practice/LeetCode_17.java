class Solution {
    public char[] options(int num){
        if(num == 2){
            char[] ans = {'a','b','c'};
            return ans;
        }else if(num == 3){
            char[] ans = {'d','e','f'};
            return ans;
        }else if(num == 4){
            char[] ans = {'g','h','i'};
            return ans;
        }else if(num == 5){
            char[] ans = {'j','k','l'};
            return ans;
        }else if(num == 6){
            char[] ans = {'m','n','o'};
            return ans;
        }else if(num == 7){
            char[] ans = {'p','q','r','s'};
            return ans;
        }else if(num == 8){
            char[] ans = {'t','u','v'};
            return ans;
        }else{
            char[] ans = {'w','x','y','z'};
            return ans;
        }
    }
    
    public List<String> combination(int n){
        if(n == 0 || n == 1){
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        int lastDig = n % 10;
        n = n / 10;
        
        List<String> smallAns = combination(n);
        char[] charOpt = options(lastDig);
        List<String> ans = new ArrayList<>();
            
        for(int i = 0; i < smallAns.size(); i++){
            for(int j = 0; j < charOpt.length; j++){
                ans.add(smallAns.get(i) + charOpt[j]);
            }
        }
        
        return ans;
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        int n = Integer.parseInt(digits);
        return combination(n);
    }
}
