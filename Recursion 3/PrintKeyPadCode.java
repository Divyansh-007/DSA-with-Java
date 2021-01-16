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
    
    public static void printKeypad(int input, String outputSoFar) {
		if(input == 0 || input == 1) {
			System.out.println(outputSoFar);
			return;
		}
		
		int lastDigit = input % 10;
		input = input / 10;
		char[] choices = options(lastDigit);
		for(int i = 0; i < choices.length; i++) {
			printKeypad(input, choices[i] + outputSoFar);
		}
	}
    
    public static void printKeypad(int input){
        // Write your code here
        System.out.println("");
        printKeypad(input, "");


    }
}
