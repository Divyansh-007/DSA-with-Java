import java.util.*;

public class Main {

    public static int largestRectanglePerimeter(int[] heights) {
        int n = heights.length;
        int max = Integer.MIN_VALUE;

        int[] rb = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        rb[n - 1] = n;

        for(int i = n - 2; i >= 0; i--){
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                rb[i] = n;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[] lb = new int[n];
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;

        for(int i = 1; i < n; i++){
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0 ; i < n; i++){
            int peri;
            if(heights[i] == 0){
                peri = 0;
            }else{
                peri = 2 * (heights[i] + (rb[i] - lb[i] - 1));
            }
            if(peri > max){
                max = peri;
            }
        }

        return max;
    }

    public static int maxRect(int r, int c, int[][] mat){
        if(r == 0 || c == 0){
            return 0;
        }

        int ans = largestRectanglePerimeter(mat[0]);

        for(int i = 1; i < r; i++){
            for(int j = 0; j < c; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = mat[i][j] + mat[i - 1][j];
                }
            }

            ans = Math.max(ans,largestRectanglePerimeter(mat[i]));
        }

        return ans;
    }


    public static void main(String[] args) {
        /* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

        // Write your code here
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        char[][] flat = new char[r][c];

        for(int i = 0; i < r; i++){
            String curr = s.next();
            flat[i] = curr.toCharArray();
        }

        int[][] modified = new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(flat[i][j] == '.'){
                    modified[i][j] = 1;
                }else{
                    modified[i][j] = 0;
                }
            }
        }
        
        System.out.println(maxRect(r,c,modified) - 1);

    }

}
