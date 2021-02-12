public class Solution {
public static void printBinary(int count_1, int count_0, String ans, int n) {
		if(count_1 < count_0) {
			return;
		}
		
		if(ans.length() == n) {
			System.out.println(ans);
			return;
		}

		printBinary(count_1 + 1, count_0, ans + '1', n);
		printBinary(count_1, count_0 + 1, ans + '0', n);

	}

	public static void printBinary(int n) {
		printBinary(0, 0, "", n);
	}

}
