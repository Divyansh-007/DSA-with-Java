class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        
        Arrays.sort(salary);
        double total = 0;
        
        for(int i = 1; i < salary.length - 1; i++){
            total += salary[i];
        }
        
        return total / (n - 2);
    }
}
