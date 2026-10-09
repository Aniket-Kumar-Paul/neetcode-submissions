class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>(); // value -> index

        // Fill up the map
        for(int i=0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        // Iterate nums & find complement in map
        for(int i=0; i < nums.length; i++) {
            int toFind = target - nums[i];
            if(numToIndex.containsKey(toFind) && numToIndex.get(toFind)!=i) {
                return new int[]{i, numToIndex.get(toFind)};
            }
        }

        return new int[0];
    }
}
