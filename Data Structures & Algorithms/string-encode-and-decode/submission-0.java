class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length())
              .append('#')
              .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Find delimiter '#'
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }

            // Extract length
            int length = Integer.parseInt(s.substring(i, j));

            // Extract actual string
            String str = s.substring(j + 1, j + 1 + length);
            result.add(str);

            // Move pointer
            i = j + 1 + length;
        }

        return result;
    }
}
