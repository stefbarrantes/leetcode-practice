class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>(); 
        int l = 0, longestSubstr = 0;

        for(int r = 0; r < s.length(); r++) {
            while(characters.contains(s.charAt(r))){
                characters.remove(s.charAt(l));
                l++;
            } 
            characters.add(s.charAt(r));
            longestSubstr = Math.max(longestSubstr, r - l + 1);        
        }

        return longestSubstr;
    }
}
