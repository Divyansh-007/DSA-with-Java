public class solution {

    public static char[] options(int num) {
		if(num == 2) {
			char[] choices = {'a','b','c'};
			return choices;
		}else if(num == 3) {
			char[] choices = {'d','e','f'};
			return choices;
		}else if(num == 4) {
			char[] choices = {'g','h','i'};
			return choices;
		}else if(num == 5) {
			char[] choices = {'j','k','l'};
			return choices;
		}else if(num == 6) {
			char[] choices = {'m','n','o'};
			return choices;
		}else if(num == 7) {
			char[] choices = {'p','q','r','s'};
			return choices;
		}else if(num == 8) {
			char[] choices = {'t','u','v'};
			return choices;
		}else {
			char[] choices = {'w','x','y','z'};
			return choices;
		}
	}

    
    // Return a string array that contains all the possible strings
    public static String[] keypad(int n){
        // Write your code here
        if(n == 0 || n == 1) {
            String ans[] = {""};
            return ans;
        }

        int lastDigit = n % 10;
        n = n / 10;
        String[] smallAns = keypad(n);
        char[] charOptions = options(lastDigit);
        String[] ans;

        if(smallAns.length == 1) {
            ans = new String[(smallAns.length * charOptions.length) + 1];

            int k = 0;

            for(int i = 0; i < smallAns.length; i++) {
                ans[k] = smallAns[i];
                k = k + 1;
            }

            for(int i = 0; i < smallAns.length; i++) {
                for(int j = 0; j < charOptions.length; j++) {
                    ans[k] = smallAns[i] + charOptions[j];
                    k = k + 1;
                }
            }
        }else {
            ans = new String[((smallAns.length - 1) * charOptions.length) + 1];

            ans[0] = "";
            int k = 1;

            for(int i = 1; i < smallAns.length; i++) {
                for(int j = 0; j < charOptions.length; j++) {
                    ans[k] = smallAns[i] + charOptions[j];
                    k = k + 1;
                }
            }

        }
        return ans;


    }

}
