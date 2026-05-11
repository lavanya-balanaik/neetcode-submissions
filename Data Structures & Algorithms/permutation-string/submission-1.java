class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s2.length() < s1.length()) return false;
        
        int[] count = new int[26];
        int left = 0;
        for(char c : s1.toCharArray()){
            count[c - 'a']++;
        }

        for(int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);

            count[c - 'a']--;

            while(count[c - 'a'] < 0) {
                count[s2.charAt(left) - 'a']++;
                left++;
            }
            if(right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
