import java.util.HashMap;

public class PairSumToZero {

	public static int PairSum(int[] input, int size) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < size; i++) {
			if(map.containsKey(input[i])) {
				map.put(input[i], map.get(input[i]) + 1);
				continue;
			}
			map.put(input[i], 1);
		}

		int pairCount = 0;

		if(map.containsKey(0)) {
			int n = map.get(0);
			int zeroPairs = (n * (n - 1)) / 2;
			pairCount = pairCount + zeroPairs;

			map.remove(0);
		}

		if(map.size() == 0) {
			return pairCount;
		}


		for(int i = 0; i < size; i++) {
			if(input[i] == 0) {
				continue;
			}else {
				int currFreq = map.get(input[i]);
				if(map.containsKey(input[i] * -1)) {
					int oppFreq = map.get(input[i] * -1);
					int pairs = currFreq * oppFreq;
					pairCount = pairCount + pairs;
					map.put(input[i], 0);
					map.put(input[i] * -1, 0);
					continue;
				}
			}
		}

		return pairCount;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 1, -2, 2, 3};
		int[] arr1 = {-2, 2, 6, 2, -2, -6, 3};
		int[] arr2 = {0, 0, 0, 0, 0};
		int[] arr3 = {0, 0, 0, 0, 1};
		System.out.println(PairSum(arr, 5));
		System.out.println(PairSum(arr1, 7));
		System.out.println(PairSum(arr2, 5));
		System.out.println(PairSum(arr3, 5));
	}

}
