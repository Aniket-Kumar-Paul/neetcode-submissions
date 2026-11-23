class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        // frequency arrays
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // update freq. array for first substring
        for(int i=0; i<s1.length(); i++) {
            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;
        }

        // initial matches for the first substring
        int matches = 0;
        for(int i=0; i<26; i++) {
            if(s1Freq[i]==s2Freq[i]) matches++;
        }

        // check rest of the string s2 with fixed window size of s1 length
        // add char at r, remove char at l - one window at a time
        int l=0;
        for(int r=s1.length(); r<s2.length(); r++) {
            if(matches==26) {
                return true;
            }

            // add new char at r, & update it's freq
            int index = s2.charAt(r)-'a';
            s2Freq[index]++;
            if(s1Freq[index] == s2Freq[index]) { // was unequal -> now equal
                matches++;
            } else if(s1Freq[index]+1 == s2Freq[index]) { // was equal -> now unequal
                matches--;
            }

            // remove char at l, & update it's freq
            index = s2.charAt(l)-'a';
            s2Freq[index]--;
            if(s1Freq[index] == s2Freq[index]) {
                matches++;
            } else if(s1Freq[index]-1 == s2Freq[index]) {
                matches--;
            }

            // update l
            l++;
        }

        return matches==26;
    }
}
