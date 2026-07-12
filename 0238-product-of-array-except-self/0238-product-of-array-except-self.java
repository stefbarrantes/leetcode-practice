class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] sufix = new int[n];
        int[] output = new int[n];

        for(int i = 0; i < n; i++) {
            // fill prefix
            prefix[i] = nums[i] * (i == 0 ? 1 : prefix[i - 1]);
        }

        for(int j = n - 1; j >= 0; j--) {
            // fill sufix
            sufix[j] = nums[j] * (j == n - 1 ? 1 : sufix[j + 1]);
        }

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                output[i] = sufix[i + 1];
            } else if( i == n - 1 ) {
                output[i] = prefix[i - 1];
            } else {
                output[i] = prefix[i - 1] * sufix[i + 1];
            }
        }
        return output;
    }
}