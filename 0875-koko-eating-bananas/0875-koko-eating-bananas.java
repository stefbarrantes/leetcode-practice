class Solution {
    public int minEatingSpeed(int[] piles, int h) { 
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int minEatingSpeed = r;

        while(l <= r) {
            int k = l + (r - l) / 2;

            long time = 0; 
            for(int pile : piles) {
                time += Math.ceil((double) pile / k);
            }

            if(time <= h){
                minEatingSpeed = k;
                r = k - 1; 
            } else {
                l = k + 1;
            }
        }

        return minEatingSpeed;
    }
}