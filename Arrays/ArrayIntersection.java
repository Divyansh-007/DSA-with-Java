import java.util.Arrays;

public class Solution{  

    public static void intersections(int arr1[], int arr2[]) {
        //Your code goes here
        if(arr1.length==0) {
            return;
        }else if(arr1.length!=0 && arr2.length==0){
            return;
        }else {
            for(int i=0;i<arr1.length;i++) {
                for(int j=0;j<arr2.length;j++) {
                    if(arr1[i]==arr2[j]) {
                        System.out.print(arr1[i]+" ");
                        arr2[j] = Integer.MIN_VALUE;
                        break;
                    }
                }
            }
        }
    }
}
