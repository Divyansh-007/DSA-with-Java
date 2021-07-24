class Solution {
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(num);
        int len = (mag + 3) / 4;
        char[] hexa = new char[len];
        int digit;
        
        do{
            digit = num & 0xf;
            hexa[--len] = digit < 10 ? (char)(digit + 48) : (char)(digit + 87);
            num >>>= 4;
        }
        while(num != 0);
        
        return new String(hexa);
    }
}
