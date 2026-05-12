class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                if (s.equals("+")) {
                    stack.push(a + b);
                } 
                else if (s.equals("-")) {
                    stack.push(a - b);
                } 
                else if (s.equals("*")) {
                    stack.push(a * b);
                } 
                else {
                    stack.push(a / b);
                }

            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }
}