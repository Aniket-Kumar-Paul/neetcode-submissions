class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> numset = new HashSet<>();
        // convert to set to avoid duplicates counting
        for (int num : nums) {
            numset.add(num);
        }

        for (int num : numset) {
            // start counting for subsequence, only if it's the starting element
            if(!(numset.contains(num-1))) {
                int length = 1;
                while(numset.contains(num+length)) {
                    length++;
                }
                result = Math.max(result, length);
            }
        }

        return result;
    }
}
