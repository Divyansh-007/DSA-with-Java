class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> stack = new Stack();
        
        for(char ch : s.toCharArray()){
            if(stack.empty() || stack.peek().getKey() != ch){
                stack.add(new Pair<Character,Integer>(ch,1));
            }
            else{
                Pair<Character,Integer> pair = stack.pop();
                stack.add(new Pair(pair.getKey(),pair.getValue() + 1));
            }
            
            if(stack.peek().getValue() == k){
                stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.empty()){
            Pair<Character,Integer> pair = stack.pop();
            for(int i=0; i < pair.getValue(); i++){
                sb.append(pair.getKey());
            }
        }
        
        return sb.reverse().toString();
    }
}
