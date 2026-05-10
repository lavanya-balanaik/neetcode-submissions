class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for (Integer num : set){
            // Start only from beginning of sequence
            if(!set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num + len)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
