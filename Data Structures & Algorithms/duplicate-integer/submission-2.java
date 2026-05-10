class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        int length = nums.length;
        if(length == 0 || length == 1) return false;

         boolean result = false;

         for(int num : nums) {
                result = set.add(num);
                if(!result) break;
         }
         return !result;
    }
}