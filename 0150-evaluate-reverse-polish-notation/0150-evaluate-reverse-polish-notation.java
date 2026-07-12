class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> values = new ArrayDeque<>();
        int izq;
        int der;

        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+":
                    values.push(values.pop() + values.pop());
                    break;
                case "-":
                    der = values.pop();
                    izq = values.pop();
                    values.push(izq - der);
                    break;
                case "*":  
                    values.push(values.pop() * values.pop());
                    break;
                case "/":
                    der = values.pop();
                    izq = values.pop();
                    values.push(izq / der);
                    break;
                default:
                    values.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return values.pop();
    }
}