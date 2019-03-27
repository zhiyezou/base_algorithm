package sort.me;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueConvert {
    public class Stack2Queue {
        private Stack<Integer> push;
        private Stack<Integer> pop;

        public Stack2Queue() {
            this.push = new Stack<>();
            this.pop = new Stack<>();
        }

        public void push(Integer i) {
            push.push(i);
        }

        public Integer pop() {
            while (push.empty()) {
                pop.push(push.pop());
            }

            return pop.pop();
        }
    }

    public class Queue2Stack {
        private Queue<Integer> push;
        private Queue<Integer> pop;

        public Queue2Stack() {
            this.push = new LinkedList<>();
            this.pop = new LinkedList<>();
        }

        public void push(Integer i) {
            push.add(i);
        }

        public Integer poll() {
            while (push.size() > 1) {
                pop.add(push.poll());
            }
            Integer res = push.poll();
            swap();
            return res;
        }

        public void swap() {
            Queue<Integer> tmp = push;
            push = pop;
            pop = tmp;
        }
    }
}
