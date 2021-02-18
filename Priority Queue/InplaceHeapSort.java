public class Solution {

    public static void downHeapify(int[] arr, int i, int n){
        int parentIndex = i;
		int leftChildIndex = (2 * parentIndex) + 1;
		int rightChildIndex = (2 * parentIndex) + 2;
		
		while(leftChildIndex < n) {
			int minIndex = parentIndex;
			if(arr[leftChildIndex] < arr[minIndex]) {
				minIndex = leftChildIndex;
			}
			
			if(rightChildIndex < n && (arr[rightChildIndex] < arr[minIndex])) {
				minIndex = rightChildIndex;
			}
			
			if(arr[minIndex] == arr[parentIndex]) {
				return;
			}
			
			int temp = arr[parentIndex];
			arr[parentIndex] = arr[minIndex];
			arr[minIndex] = temp;
			parentIndex = minIndex;
			leftChildIndex = (2 * parentIndex) + 1;
			rightChildIndex = (2 * parentIndex) + 2;
		}
    }
    
	public static void inplaceHeapSort(int arr[]) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Change in the given input itself.
		* Taking input and printing output is handled automatically.
		*/
        int  n = arr.length;
		
		// building heap in O(n) : leaf node concept
		for(int i = (n / 2) - 1; i >= 0; i--) {
			downHeapify(arr, i, n); // min heap concept
		}
		
		// sorting the array in decreasing order bcz of using min heap concept
		for(int i = n - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			downHeapify(arr, 0, i);
		}
	}
}
