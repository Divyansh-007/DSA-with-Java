
public class Solution { 

    public static int binarySearch(int[] arr, int x) {
    	//Your code goes here
        int index = -1;
		int s = 0;
		int e = arr.length-1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(arr[mid]<x) {
				s = mid+1;
				continue;
			}else if(arr[mid]>x) {
				e = mid-1;
				continue;
			}else {
				index = mid;
				break;
			}
		}
		return index;
    }

}
