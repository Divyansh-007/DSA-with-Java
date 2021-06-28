class Solution {
    public void duplicateZeros(int[] arr) {
        int duplicates = 0;
        int len = arr.length - 1;
        
        for(int index = 0; index <= len - duplicates; index++){
            if(arr[index] == 0){
                if(index == len - duplicates){
                    arr[len] = 0;
                    len -= 1;
                    break;
                }
                duplicates++;
            }
        }
        
        int last = len - duplicates;
        
        for(int i = last; i >= 0; i--){
            if(arr[i] == 0){
                arr[i + duplicates] = 0;
                duplicates--;
                arr[i + duplicates] = 0;
            }else{
                arr[i + duplicates] = arr[i];
            }
        }
    }
}
