

// class Solution {

//     public int[][] kClosest(int[][] points, int k) {

//         return Arrays.stream(points)

//                 .sorted(Comparator.comparingInt(
//                         p -> p[0] * p[0] + p[1] * p[1]
//                 ))

//                 .limit(k)

//                 .toArray(int[][]::new);
//     }
// }



class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // Max Heap based on distance
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                    (a, b) ->
                        distance(b) - distance(a)
                );

        for (int[] point : points) {

            maxHeap.offer(point);

            // Maintain heap size = k
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        int i = 0;

        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] point) {

        return point[0] * point[0]
             + point[1] * point[1];
    }
}