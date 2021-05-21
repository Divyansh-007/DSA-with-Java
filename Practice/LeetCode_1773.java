class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int key = 0;
        
        if(ruleKey.equals("color")){
            key = 1;
        }else if(ruleKey.equals("name")){
            key = 2;
        }
        
        for(List curr : items){
            if(curr.get(key).equals(ruleValue)){
                count++;
            }
        }
        
        return count;
    }
}
