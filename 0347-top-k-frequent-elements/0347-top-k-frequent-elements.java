class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       // Build frequency map
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int num : nums) {
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        // Create bucket array — index = frequency, value = list of elements
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Fill buckets — place each element at its frequency index
        seen.forEach((key, count) -> {
            bucket[count].add(key);
        });

        // Read right to left (highest frequency first)
        int[] result = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 1 && idx < k; i--) {
            for (int num : bucket[i]) {
              //  write at current index then move to next slot
                result[idx++] = num; 
                if (idx == k) return result;
            }
        }  
        return result; 
    }
}