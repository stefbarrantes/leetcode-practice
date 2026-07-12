class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> wordsMap = new HashMap<>();

        for(String word: strs){
            int[] charsCount = new int[26];
 
            for(int j = 0; j < word.length(); j++) {
                int charPosition = word.charAt(j) - 'a';
                charsCount[charPosition] = charsCount[charPosition] + 1;
            }

            String key = Arrays.toString(charsCount);  

            if (!wordsMap.containsKey(key)) {
                wordsMap.put(key, new ArrayList<>());
            }

            wordsMap.get(key).add(word);
        }
        return new ArrayList<>(wordsMap.values());
    }
}