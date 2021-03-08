import java.util.Scanner;

public class Main {
  public static void print(int arr[][], int minI, int maxI, int minJ, int maxJ){
        for(int i=minI;i<=maxI;i++){
            for(int j=minJ;j<=maxJ;j++){
                if(arr[i][j] == 1)
                	System.out.print("X");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        
        int arr[][] = new int[n+2][m+2];
        int ans[][] = new int[n+2][m+2];
        
        for(int i=1;i<=n;i++){
            String str = s.next();
            for(int j=1;j<=m;j++){
                char c = str.charAt(j-1);
                if(c == '.'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }
        
        int minI = 100;
        int maxI = 0;
        int minJ = 100;
        int maxJ = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int count = 0;
                if(arr[i-1][j] == 1){
                    count++; 
                }  
                if(arr[i][j-1] == 1){
                    count++; 
                }
                if(arr[i+1][j] == 1){
                    count++; 
                }  
                if(arr[i][j+1] == 1){
                    count++; 
                }
                if(count >= 2 && arr[i][j] == 1){
                    ans[i][j] = 1;
                }
                
                if(ans[i][j] == 1){
				          	minI = Math.min(minI, i);
                    maxI = Math.max(maxI, i);
                    minJ = Math.min(minJ, j);
                    maxJ = Math.max(maxJ, j);
                }
            }

        }
        print(ans, minI, maxI, minJ, maxJ);
    }

}
