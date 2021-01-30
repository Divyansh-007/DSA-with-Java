import java.util.*;
public class solution {
	
	public static boolean CheckSubset(int[] arr1, int n1, int[] arr2, int n2) {
		/*Your class should be named solution. 
		*Don't write main().
		*Don't take input, it is passed as function argument.
		*Don't print output.
		*Taking input and printing output is handled automatically.
		*/ 
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n2; i++){
            if(map.containsKey(arr2[i])){
                map.put(arr2[i],map.get(arr2[i]) + 1);
                continue;
            }
            
            map.put(arr2[i],1);
        }
        
        for(int i = 0; i < arr1.length; i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],map.get(arr1[i]) - 1);
                continue;
            }
        }
        
        
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key) > 0){
                return false;
            }
        }
        
        return true;
	}
}
