class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            if (nums[l] < nums[r]) {  // nums is already sorted
                return nums[l];
            }

            int m = l + (r - l) / 2; 
            
            if(nums[m] > nums[r]) { // the minimum must be to the right
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return nums[l];
    }
}
