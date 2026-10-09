class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Build frequency map
        Map<Integer, Integer> countMap = new HashMap<>(); // num -> freq.
        for(int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0)+1);
        }

        // Build min-heap of size k
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]); // freq. -> num
        for(Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            minHeap.offer(new int[]{e.getValue(), e.getKey()});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = minHeap.poll()[1];
        }
        return res;
    }
}
