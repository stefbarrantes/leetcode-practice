class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
		Deque<Character> que = new ArrayDeque<>();

		if(!(s.length() >= 2)) {
			return false;
		}

		for(char c : chars) {
			if(c == '(' || c == '[' || c == '{') {
				que.push(c);
			} else {
				if(!que.isEmpty() && (que.peek() == '(' && c == ')' || que.peek() == '[' && c == ']' || que.peek() == '{' && c == '}')) {
					que.pop();
				} else {
					return false;
				}
			}
		}
		return que.isEmpty();
    }
}