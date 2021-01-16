public class solution {

    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }

        return n * fact(n-1);
    }

    public static String[] permutationOfString(String input){
        // Write your code here
        if(input.length() == 0) {
            String[] ans = new String[1];
            ans[0] = "";
            return ans;
        }

        String[] ans = new String[fact(input.length())];
        int k = 0;
        for(int i = 0 ; i < input.length(); i++) {
            char ch = input.charAt(i);
            String rem = input.substring(0, i) + input.substring(i + 1, input.length());
            String[] smallAns = permutationOfString(rem);
            for(int j = 0; j < smallAns.length; j++) {
                ans[k] = ch + smallAns[j];
                k = k + 1;
            }
        }

        return ans;		
    }

}
