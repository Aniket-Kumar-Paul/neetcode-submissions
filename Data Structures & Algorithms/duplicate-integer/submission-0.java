class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seenValues = new HashSet<>();
        for(int num : nums) {
            if(seenValues.contains(num)) {
                return true;
            }
            seenValues.add(num);
        }
        return false;
    }
}