class Solution {
    
    public static void merge(int[] arr1, int[] arr2, int [] output) {
		int m = arr1.length;
		int n = arr2.length;
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < m && j < n) {
			if(arr1[i] <= arr2[j]) {
				output[k] = arr1[i];
				i = i+1;
				k = k+1;
			}else {
				output[k] = arr2[j];
				j = j+1;
				k = k+1;
			}
		}
		
		if(i < m) {
			while(i < m) {
				output[k] = arr1[i];
				i = i+1;
				k = k+1;
			}
		}
		
		if(j < n) {
			while(j < n) {
				output[k] = arr2[j];
				j = j+1;
				k = k+1;
			}
		}
	}
    
    public static void mergeSort(int[] input){
        if(input.length <= 1) {
			return;
		}
		
		int[] s1 = new int[input.length/2];
		int[] s2 = new int[input.length - s1.length];
		
		for(int i = 0; i < input.length/2; i++) {
			s1[i] = input[i];
		}
		
		for(int j = input.length/2; j < input.length; j++) {
			s2[j - (input.length/2)] = input[j];
		}
		
		mergeSort(s1);
		mergeSort(s2);
		
		merge(s1,s2,input);	
	}
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
}
