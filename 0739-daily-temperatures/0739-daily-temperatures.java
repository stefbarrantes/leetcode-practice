class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length]; // by Java initializes every element to 0
        Deque<int[]> stack = new ArrayDeque<>(); // [temp, index]

        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] pair = stack.pop();
                output[pair[1]] =  i - pair[1];
            }
            stack.push(new int[]{temp, i});
            
        }
        return output;
    }
}