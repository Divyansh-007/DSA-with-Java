class Pair{
    int a;
    int b;
    int sum;
    
    Pair(int x,int y, int z){
        this.a = x;
        this.b = y;
        this.sum = z;
    }
}

class Comp implements Comparator<Pair>{
    public int compare(Pair p, Pair q){
        if(p.sum < q.sum)
            return 1;
        else if(p.sum > q.sum)
            return -1;
        else
            return 0;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
        int m = nums1.length;
        int n = nums2.length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pq.size() < k){
                    pq.add(new Pair(nums1[i],nums2[j],nums1[i] + nums2[j]));
                }else{
                    Pair curr = pq.peek();
                    if(curr.sum > nums1[i] + nums2[j]){
                        pq.poll();
                        pq.add(new Pair(nums1[i],nums2[j],nums1[i] + nums2[j]));
                    }
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(Pair p : pq){
            List<Integer> curr = new ArrayList<>();
            curr.add(p.a);
            curr.add(p.b);
            ans.add(curr);
        }
        return ans;
    }
}
