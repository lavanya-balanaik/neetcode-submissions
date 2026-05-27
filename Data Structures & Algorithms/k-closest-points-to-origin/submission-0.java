

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        return Arrays.stream(points)

                .sorted(Comparator.comparingInt(
                        p -> p[0] * p[0] + p[1] * p[1]
                ))

                .limit(k)

                .toArray(int[][]::new);
    }
}