class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxArea = 0; 
        while(l < r) {
            int newArea = Math.min(height[l], height[r]) * (r - l);
            if(newArea > maxArea) {
                maxArea = newArea;
            }

            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        } 
        return maxArea;
    }
}