class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;

        Arrays.sort(piles);

        int left = 1;
        int right = piles[length-1];
        int answer = right;

        while(left <= right) {
            int mid = (left + right) / 2;
            int hours = hoursToEat(piles, mid);
            if(hours <= h) {
                answer = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private int hoursToEat(int[] piles, int mid) {
        int totalHours = 0;
        for(int pile : piles) {
            // totalHours += Math.ceil((double)pile/mid);
            totalHours += (pile + mid - 1) / mid;
        }
        return totalHours;
    }
}
