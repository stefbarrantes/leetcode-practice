class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charsCount = new HashMap<>();
        int l = 0, longest = 0; 

        for(int r = 0; r < s.length(); r++) {
            charsCount.put(s.charAt(r), charsCount.getOrDefault(s.charAt(r), 0) + 1);

            int maxFreq = 0;
            for (int count : charsCount.values()) {
                maxFreq = Math.max(maxFreq, count);
            }

            int windowSize = r - l + 1; 
            if((windowSize - maxFreq) <= k) {
                longest = Math.max(longest, windowSize);
            } else {
                int count = charsCount.get(s.charAt(l));

                if (count == 1) {
                    charsCount.remove(s.charAt(l));
                } else {
                    charsCount.put(s.charAt(l), count - 1);
                }

                l++;   
            }            
        }
       return longest;
    }
}
