class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        for(char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0)+1);
        }

        int currMatch = 0;
        int needMatch = countT.size();
        int resLength = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        int[] res = {-1, -1};

        int l = 0;
        for(int r=0; r<s.length(); r++) {
            // add char at r to the window
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+1);

            // if the count matches, increment the current match
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                currMatch++;
            }

            // keep incrementing above until currMatch is equal to needMatch
            // once that happens, we try to shrink it by incrementing l
            while(currMatch == needMatch) {
                if((r-l+1) < resLength) { // update resLength
                    resLength = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                // remove l & update window first & currMatch
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) { // invalid window
                    currMatch--;
                }
                l++;
            }       
        }

        return resLength==Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
