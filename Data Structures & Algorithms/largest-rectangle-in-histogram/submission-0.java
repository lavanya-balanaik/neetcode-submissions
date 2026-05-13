class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                   currHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int rightBoundary = i;

                int leftBoundary =
                    stack.isEmpty() ? -1 : stack.peek();

                int width = rightBoundary - leftBoundary - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}