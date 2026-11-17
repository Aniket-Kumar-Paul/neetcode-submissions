class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Using sliding window & hashmap
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        int l = 0;
        int result = 0;

        for (int r=0; r<s.length(); r++) {
            if(lastIndexMap.containsKey(s.charAt(r))) {
                l = Math.max(lastIndexMap.get(s.charAt(r))+1, l);
            }
            lastIndexMap.put(s.charAt(r), r);
            result = Math.max(result, r-l+1);
        }
        return result;
    }
}
