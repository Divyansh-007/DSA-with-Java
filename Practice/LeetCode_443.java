class Solution {
    public int compress(char[] chars) {
        int curr = 0;
        int count = 1;
        int i;
        
        for(i = 0; i < chars.length; i++) {
            if(i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            }else if(count > 1){
                chars[curr++] = chars[i];
                if(count > 9) {
                    String countStr = String.valueOf(count);
                    for(char c : countStr.toCharArray())
                        chars[curr++] = c;
                } else 
                    chars[curr++] = Character.forDigit(count, 10);
                
                count = 1;
            } else {
                chars[curr++] = chars[i];
            }
        }
        
        return curr;   
    }
}
