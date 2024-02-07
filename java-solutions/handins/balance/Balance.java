import java.util.Scanner;

class Balance {

    private boolean isCorrespondingElm(char c1, char c2) {
        switch (c1) {
            case '(': return c2 == ')';
            case '[': return c2 == ']';
            case '{': return c2 == '}';
            default: return false;
        }
    }
    
    private boolean isBalanced(String s) {
        if (s.length() == 0) { return true; }                   // empty strings are considered balanced
        if (s.length() % 2 != 0) { return false; }              // if uneven length, s can't be balanced

        Stack<Character> w = new Stack<Character>(s.length());
        for (int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {             // if c is opening parenthesis, push!
                w.push(c);
            } else {
                if (w.isEmpty()) { return false; }              // if empty here, there is imbalance in s
                else {
                    w.pop();                                    // decrement top pointer 
                    char t = w.peek();                          // get top element in stack
                    if (!((t == '(' || t == '[' || t == '{')    
                        && isCorrespondingElm(t, c))) {
                            return false;                       // imbalance if t is not corresponding elm to c
                    }
                }
            }
        } return w.isEmpty();                                   // if empty, s is balanced
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        Balance b = new Balance();
        System.out.println(b.isBalanced(s) ? 1 : 0);
    }

    class Stack<Item> {                                         // stack implementation (see p. 135)
        private Item[] w;
        private int t;

        @SuppressWarnings("unchecked")
        public Stack(int N) {
            w = (Item[]) new Object[N];
            t = 0;
        } 

        private void push(Item i) { 
            w[t++] = i; 
        }
        
        private Item pop() { 
            return w[t--]; 
        }

        private Item peek() {
            return w[t];
        }

        private boolean isEmpty() { 
            return t == 0; 
        }
    }
}
