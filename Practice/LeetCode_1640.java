class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int sizeArr = arr.length, sizePieces = pieces.length;
        HashMap<Integer, Integer> arrIndex = new HashMap<>();
        for (int i = 0; i < sizeArr; i++) {
            arrIndex.put(arr[i], i);
        }
        for (int[] row: pieces) {
            if (!arrIndex.containsKey(row[0])) {
                return false;
            }
            if (row.length > 1) {
                int indexArr = arrIndex.get(row[0]);
                for (int i = 1; i < row.length; i++) {
                    indexArr++;
                    if (indexArr > sizeArr - 1 || arr[indexArr] != row[i]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
