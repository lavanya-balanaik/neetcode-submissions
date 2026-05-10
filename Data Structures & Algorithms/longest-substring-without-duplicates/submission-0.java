class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new LinkedList<>();
        int max = 0;

        for(Character c : s.toCharArray()) {
            while(list.contains(c)) {
                list.removeFirst();
            }
            list.add(c);
            max = Math.max(max, list.size());
        }
       return max; 
    }
}

