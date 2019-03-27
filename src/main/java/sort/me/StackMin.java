package sort.me;

import java.util.Stack;

public class StackMin {

    static Stack<Integer> data = new Stack<>();
    static Stack<Integer> min = new Stack<>();

    public static void main(String[] args) {
        push(4);
        push(3);
        push(2);
        System.out.println(getMin());
        System.out.println(getMin());
        System.out.println(getMin());
    }

    public static void push(int i) {
        data.push(i);
        if (min.isEmpty()) {
            min.push(i);
        }
        if (i < min.peek()) {
            min.push(i);
        } else {
            min.push(min.peek());
        }
    }

    public static int getMin() {
        return min.pop();
    }
}
