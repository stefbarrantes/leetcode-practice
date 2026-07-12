class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
		for(int n : nums) {
			numsSet.add(n);
		}

		int longest = 0;
		for(int n : numsSet) {
			// checks if its the first item of a sequence
			if(!numsSet.contains(n - 1)){
				int sequenceLength = 1;
				while(numsSet.contains( n + sequenceLength)) {
					sequenceLength++;
				}
				longest = Math.max(longest, sequenceLength);
			}
		}

		return longest;
    }
}