class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] result = new int[2];
        if(nums == null || nums.length == 0 )  return new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
       return new int[]{-1, -1}; 
    }
}
