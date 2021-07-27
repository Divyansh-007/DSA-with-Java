class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String para =  paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = para.split("\\s+");
        List<String> banWords = new ArrayList<>();
        
        for(String str : banned){
            banWords.add(str);
        }
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str : words){
            if(!banWords.contains(str)){
                if(map.containsKey(str)){
                    map.put(str,map.get(str) + 1);
                    continue;
                }
                
                map.put(str,1);
            }
        }
        
        return Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey();
        
        
    }
}
