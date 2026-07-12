class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(visited.containsKey(target - nums[i])) {
                return new int[] { visited.get(target - nums[i]) , i };
            } else {
                visited.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}