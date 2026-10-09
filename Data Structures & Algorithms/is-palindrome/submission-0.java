class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            // Skip non-alphanumeric characters
            while (l < r && !isAlphaNumeric(s.charAt(l))) {
                l++;
            }
            while (l < r && !isAlphaNumeric(s.charAt(r))) {
                r--;
            }
            // compare the alphanumeric characters
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++; r--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c>='A' && c<='Z' || c>='a' && c<='z' || c>='0' && c<='9');
    }
}
