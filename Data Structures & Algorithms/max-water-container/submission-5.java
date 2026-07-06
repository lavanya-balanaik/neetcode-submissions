class Solution {
    public int maxArea(int[] heights) {
        int length = heights.length;
        if(length <= 1) return 0;

        int maxArea = 0;
        int left = 0;
        int right = length - 1;

        while(left < right) {
            maxArea = Math.max(Math.min(heights[left], heights[right]) * (right - left), maxArea);
            if(heights[left] < heights[right]) {
                left++;
            } else right--;
        }
        return maxArea;
    }
}
