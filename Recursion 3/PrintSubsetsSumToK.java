public class solution {
    public static void printSubsetsSumTok(int input[],int si, int output[], int k) {
        // Write your code here
        if(si == input.length) {
            if(k == 0) {
                for(int elem : output) {
                    System.out.print(elem + " ");
                }
                System.out.println();
                return;
            }else {
                return;
            }
        }

        int[] newOutput;
        newOutput = new int[output.length + 1];
        int m = 0;
        for(int i = 0; i < output.length; i++) {
            newOutput[m] = output[i];
            m = m + 1;
        }

        newOutput[m] = input[si];

        printSubsetsSumTok(input, si + 1, output, k);
        printSubsetsSumTok(input, si + 1, newOutput, k - input[si]);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        // Write your code here
        int output[] = {};
        printSubsetsSumTok(input, 0, output, k);

    }

}
