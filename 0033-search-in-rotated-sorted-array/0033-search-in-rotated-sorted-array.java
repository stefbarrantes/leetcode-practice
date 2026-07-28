class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l) / 2; 
            if(nums[m] == target) {
                return m;
            }
            // m is in the left-sorted side
            if(nums[m] >= nums[l]){
                if(nums[m] < target || target < nums[l]){ 
                    l = m + 1; 
                } else {
                    r = m - 1;
                }
            } else {
                // m is in the right-sorted side
                if(target < nums[m] || target > nums[r]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }
}
