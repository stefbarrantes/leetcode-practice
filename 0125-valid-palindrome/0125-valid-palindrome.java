class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0; 
        int r = s.length() - 1; 

        while(l < r) {
            while(l < r && !isAlphanumeric(s.charAt(l))) {
                l++;
            }
            while(r > l && !isAlphanumeric(s.charAt(r))) {
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++; r--;
        }

        return true;
    }

    public boolean isAlphanumeric(char c){
        if(c >= 'A' && c <= 'Z' ||  c >= 'a' && c <= 'z' || c >= '0' && c <= '9') return true;
        return false;
        // follow-up note: I could have used isAlphanumeric = Character.isLetterOrDigit(c);
    }
}