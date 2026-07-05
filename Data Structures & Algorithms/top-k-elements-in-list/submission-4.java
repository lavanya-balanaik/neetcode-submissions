class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if(nums == null || nums.length == 0) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a,b) -> Integer.compare(map.get(b), map.get(a)));

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = keys.get(i);
         }
        return result;
    }
}
