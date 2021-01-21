import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;

public class ArrayIntersection {
	
	public static void intersection(int[] arr1, int[] arr2) {
	    //Your code goes here
		Arrays.sort(arr2);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < arr1.length; i++) {
			if(map.containsKey(arr1[i])) {
				map.put(arr1[i], map.get(arr1[i]) + 1);
				continue;
			}
			
			map.put(arr1[i], 1);
		}
		
		Set<Integer> keys = map.keySet();
		
		for(int i = 0; i < arr2.length; i++) {
			if(map.containsKey(arr2[i]) && map.get(arr2[i]) != 0) {
				System.out.print(arr2[i] + " ");
				map.put(arr2[i], map.get(arr2[i]) - 1);
				continue;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {5, 8, 7, 4, 8 };
		int arr2[] = {4, 6, 6, 10, 8, 5, 5, 1};
		intersection(arr1, arr2);

	}

}
