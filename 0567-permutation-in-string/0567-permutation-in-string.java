class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] charCountS1 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            charCountS1[s1.charAt(i) - 'a'] ++;
        }

        int l = 0;
        int[] charCountS2 = new int[26];
        for(int r = 0; r < s2.length(); r++) {
            charCountS2[s2.charAt(r) - 'a'] ++ ;

            if(r - l + 1 == s1.length()) {
                // then i need to compare the keys to see if they are equal. 
                if (Arrays.equals(charCountS1, charCountS2)) {
                    return true;
                } else {
                    // remove the leftmost 
                    charCountS2[s2.charAt(l) - 'a'] -- ;
                    l++;
                }
            }             
        }
        return false;
    }
}