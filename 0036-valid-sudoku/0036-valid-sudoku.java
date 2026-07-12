class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> columns = new HashMap<>();
        HashMap<String, HashSet<Character>> subsquares = new HashMap<>(); // r/3 , c/3

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                char val = board[row][col];
                if(val != '.') {
                    // create a new empty Set for the row if it doesn't exist yet
                    rows.putIfAbsent(row, new HashSet<>());
                    if(rows.get(row).contains(val)) return false; // duplicate found
                    rows.get(row).add(val);

                    columns.putIfAbsent(col, new HashSet<>());
                    if(columns.get(col).contains(val)) return false;
                    columns.get(col).add(val);

                    String sqrKey = Integer.toString(row / 3) + Integer.toString(col / 3);
                    subsquares.putIfAbsent(sqrKey, new HashSet<>());
                    if(subsquares.get(sqrKey).contains(val)) return false;
                    subsquares.get(sqrKey).add(val);
                }
            }
        }

        return true;
    }
}