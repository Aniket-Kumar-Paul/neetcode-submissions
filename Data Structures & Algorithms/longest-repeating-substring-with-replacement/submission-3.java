class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int result = 0, l = 0, maxFreq = 0;

        for(int r=0; r<s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0)+1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r))); // highest freq in the current window

            while((r-l+1)-maxFreq > k) { // invalid window
                count.put(s.charAt(l), count.get(s.charAt(l))-1);
                l++;
            }

            result = Math.max(result, r-l+1);
        }
        return result;
    }
}