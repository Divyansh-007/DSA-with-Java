class Solution {
    public String destCity(List<List<String>> paths) {
        if(paths.size() == 0 || paths == null){
            return "";
        }
        
        HashMap<String,String> map = new HashMap<>();
        
        for(int i = 0; i < paths.size(); i++){
            map.put(paths.get(i).get(0),paths.get(i).get(1));
        }
        
        for(String city : map.values()){
            if(!map.containsKey(city)){
                return city;
            }
        }
        
        return "";
    }
}
