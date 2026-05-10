class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1;
        int zeroCount = 0;

        for(int num : nums) {
            if (num != 0) product *= num;
            else zeroCount++;
        }

        for(int i = 0; i< nums.length; i++) {
            if (zeroCount > 1) output[i] = 0;
            else if (zeroCount == 1) output[i] = (nums[i] == 0) ? product : 0;
            else output[i] = product/nums[i];
        }
        return output;
    }
}