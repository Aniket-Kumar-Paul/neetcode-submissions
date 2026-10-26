class Solution {
    public int maxArea(int[] heights) {
        // using 2-pointers
        int l=0, r=heights.length-1, result=0;

        while (l<r) {
            int area = Math.min(heights[l], heights[r])*(r-l);
            // update result
            result = Math.max(result, area);

            // move the pointer that has shorter height (as then the next one might be possibly longer)
            if(heights[l]<=heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
