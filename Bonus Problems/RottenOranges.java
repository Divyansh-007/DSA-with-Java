import java.util.Scanner;
import java.util.*;

public class Main {

    public static int orangesRotting(int[][] box) {
        if(box == null || box.length == 0){
            return 0;
        }
        
        int rows = box.length;
        int cols = box[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(box[i][j] == 2) {
                    queue.add(new int[]{i , j});
                }
                else if(box[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh == 0){
         	return 0;   
        }
        
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || box[x][y] == 0 || box[x][y] == 2){
                        continue;
                    }
                    
                    box[x][y] = 2;
                    
                    queue.offer(new int[]{x , y});
                    
                    count_fresh--;
                }
            }
        }
        
        if(count_fresh == 0){
            return count - 1;
        }
        
        return -1;
        // return count_fresh == 0 ? count-1 : -1;
    }
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
		Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] box = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                box[i][j] = s.nextInt();
            }
        }
        
        System.out.println(orangesRotting(box));

	}

}
