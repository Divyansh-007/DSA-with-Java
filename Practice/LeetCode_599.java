public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer,List<String>> map = new HashMap <> ();
        
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if(!map.containsKey(i + j)){
                        map.put(i + j, new ArrayList < String > ());   
                    }
                    
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        
        for (int key: map.keySet()){
            minSum = Math.min(minSum, key);
        }
            
        String[] res = new String[map.get(minSum).size()];
        return map.get(minSum).toArray(res);
    }
}
