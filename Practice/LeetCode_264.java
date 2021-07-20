class Solution {
    public int nthUglyNumber(int n) {
        int[] list = new int[n];
        list[0] = 1;
        int index2 = 1, index3 = 1, index5 = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            list[i] = min;
            
            if(factor2 == min){
                factor2 = 2*list[index2];
                index2++;
            }
                
            if(factor3 == min){
                factor3 = 3*list[index3];
                index3++;
            }
                
            if(factor5 == min){
                factor5 = 5*list[index5];
                index5++;
            }
                
        }
        
        return list[n-1];
    }
}
