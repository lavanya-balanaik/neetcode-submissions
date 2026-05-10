class Solution {
    public int maxArea(int[] heights) {
        int max = 0, left = 0, right = heights.length-1;
        while(left < right) {
            max = Math.max(Math.min(heights[left], heights[right]) * (right-left)
            , max);
            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return max;
    }
}
