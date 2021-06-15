class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        double sum = 0.0;
        int si = n / 20;
        int ei = n - (n / 20);
        
        for(int i = si; i < ei; i++){
            sum += arr[i];
        }
        
        return sum / (n - (0.1 * n));
        
    }
}
