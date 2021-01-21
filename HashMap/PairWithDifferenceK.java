import java.util.HashMap;

public class PairDiffWithK {
	
	public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
				continue;
			}
			
			map.put(arr[i], 1);
		}
		
		int pairCount = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int currElem = arr[i];
			if(k == 0) {
				int n = map.get(currElem);
				int count = (n * (n - 1)) / 2;
				pairCount = pairCount + count;
				map.remove(currElem);
				
				if(map.size() == 0) {
					return pairCount;
				}
			}
			
			int rem = currElem - k;
			
			if(map.containsKey(rem)) {
				int count = map.get(currElem) * map.get(rem);
				pairCount = pairCount + count;
//				map.remove(currElem);
				map.remove(rem);
				continue;
			}
		}
		
		return pairCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 1, 2, 4};
		int[] arr1 = {4, 4, 4, 4};
		System.out.println(getPairsWithDifferenceK(arr, 3));

	}

}
