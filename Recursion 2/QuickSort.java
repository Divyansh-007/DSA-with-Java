
public class Solution {
    
    	public static int partition(int[] arr, int si, int ei) {
		int pivotElement = arr[si];
		int smallerNumberCount = 0;
		
		for(int i = si + 1; i <= ei; i++) {
			if(arr[i] < pivotElement) {
				smallerNumberCount = smallerNumberCount + 1;
			}
		}
		
		int temp =arr[si + smallerNumberCount];
		arr[si + smallerNumberCount] = pivotElement;
		arr[si] = temp;
		
		int i = si;
		int j = ei;
		
		while(i < j) {
			if(arr[i] < pivotElement) {
				i = i+1;
			}else if(arr[j] >= pivotElement) {
				j = j-1;
			}else {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i = i+1;
				j = j-1;
			}
		}
		
		return si + smallerNumberCount;
	}

	
	public static void mainSort(int[] input, int si, int ei) {
		if(si >= ei) {
			return;
		}
		
		int pivotIndex = partition(input,si,ei);
		mainSort(input, si, pivotIndex-1);
		mainSort(input, pivotIndex+1, ei);
	}
	
	
	public static void quickSort(int[] input) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
        mainSort(input,0,input.length-1);
		
	}
	
}
