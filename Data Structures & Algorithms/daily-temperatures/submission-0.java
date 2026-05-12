class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;

        int[] result = new int[length];
        for( int left = 0; left < length; left++ ) {
            int right = left + 1;
            while(right < length && temperatures[right] <= temperatures[left] ) {
                right++;
            }
            if(right < length) result[left] = (right - left);
            else result[left] = 0;
        }
        return result;
    }
}
