class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int[] result = new int[nums.length - k + 1];
        int left = 0;
        while(left < nums.length - k + 1) {
            for(int i = left; i< left + k; i++) {
                priorityQueue.offer(nums[i]);
            }
            result[left] = (priorityQueue.peek());
            priorityQueue.clear();
            left++;
        }
        
        return result;
    }
}
