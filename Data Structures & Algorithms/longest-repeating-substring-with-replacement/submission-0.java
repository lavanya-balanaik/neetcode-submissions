class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0 ;
        int maxLength = 0;
        int maxFreq = 0;

        for(int right =0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            // int window_size = right - left + 1;
            // int characters_to_replace = window_size - maxFreq ;

            while( (right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
