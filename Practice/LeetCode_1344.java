class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle = 6 * minutes;
        double minRatio = minAngle / 360;
        
        double hourAngle = minRatio * 30 + (hour == 12 ? 0 : hour * 30);
        double ans = Math.abs(hourAngle - minAngle);
        
        return ans > 180 ? 360 - ans : ans;
    }
}
