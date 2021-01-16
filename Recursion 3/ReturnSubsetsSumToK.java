public class solution {

    public static int[][] subsetsSumK(int input[], int si, int k){
        if(si == input.length) {
            if(k == 0) {
                return new int[1][0];
            }else {
                return new int[0][0];
            }
        }

        int[][] temp1 = subsetsSumK(input, si + 1, k - input[si]);
        int[][] temp2 = subsetsSumK(input, si + 1, k);

        int[][] output = new int[temp1.length + temp2.length][];
        int index = 0;

        for(int i = 0; i < temp1.length; i++) {
            output[index] = new int[temp1[i].length + 1];
            output[index][0] = input[si];
            for(int j = 0; j < temp1[i].length; j++) {
                output[index][j + 1] = temp1[i][j];
            }
            index = index + 1;
        }

        for(int i = 0; i < temp2.length; i++) {
            output[index] = new int[temp2[i].length];
            for(int j = 0; j < temp2[i].length; j++) {
                output[index][j] = temp2[i][j];
            }
            index = index + 1;
        }

        return output;
    }

    public static int[][] subsetsSumK(int input[], int k){
        int[][] ans = subsetsSumK(input, 0, k);
        return ans;
    }

}
