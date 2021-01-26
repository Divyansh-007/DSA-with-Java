import java.util.Stack;

public class Solution {

    public static int[] stockSpan(int[] price) {
        //Your code goes here
        int[] span = new int[price.length];
        Stack<Integer> index = new Stack<>();

        index.push(0);
        span[0] = 1;

        int i = 1;
        while(i <= price.length - 1) {
            
            while(!index.isEmpty()){
                if(price[i] > price[index.peek()]){
                    index.pop();
                }else{
                    break;
                }
            }
            
            if(index.isEmpty()){
                span[i] = i + 1;
                index.push(i);
            }else{
                span[i] = i - index.peek();
                index.push(i);
            }

            i = i + 1;           
        }

        return span;
    }

}
