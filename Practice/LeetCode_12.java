class Solution {
    public String intToRoman(int num) {
        String Th[] = {"","M","MM","MMM"};
        String Hun[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String Ten[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String Ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        
        return Th[num/1000] + Hun[(num % 1000) / 100] + Ten[(num % 100) / 10] + Ones[num % 10];
    }
}
