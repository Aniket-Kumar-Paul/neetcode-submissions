class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // fix one number, get the other two using two-pointers
        for(int i=0; i<nums.length; i++) {
            int firstNum = nums[i];
            // skip duplicates
            if(i>0 && nums[i]==nums[i-1]) continue;

            int l=i+1, r=nums.length-1;
            while(l<r) {
                int sum = firstNum + nums[l] + nums[r];
                if(sum==0) {
                    result.add(Arrays.asList(firstNum, nums[l], nums[r]));
                    l++; r--;
                    // skip left duplicates
                    while(l<r && nums[l]==nums[l-1]) {
                        l++;
                    }
                } else if(sum>0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
