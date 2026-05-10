class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;

        int maxLeft = 0, maxRight = 0, water = 0;
        int left =0, right = height.length -1;

        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    water += maxLeft - height[left];
                }
                left++;
            } else {
                if(height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    water += maxRight - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
