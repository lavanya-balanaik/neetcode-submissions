class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        int length = nums.length;
        if(length == 0 || length == 1) return false;

         boolean result = false;

         for(int i = 0; i<nums.length; i++) {
                result = set.add(nums[i]);
                if(!result) break;
         }
         return !result;
    }
}