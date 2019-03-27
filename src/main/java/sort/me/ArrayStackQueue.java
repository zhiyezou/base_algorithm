package sort.me;

public class ArrayStackQueue {
    public static void main(String[] args) {

        /*ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peak());*/


        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        //System.out.println(arrayQueue.pop());
        //System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.peak());
    }

    public static class ArrayStack {

        int[] arr = null;
        int index = 0;

        private ArrayStack(int len) {
            arr = new int[len];
        }

        public void push(int i) {
            if (index != arr.length) {
                arr[index++] = i;
            } else {
                throw new IndexOutOfBoundsException("stack is full");
            }
        }

        public int pop() {
            if (index < 0) {
                throw new IndexOutOfBoundsException("stack is null");
            }
            return arr[--index];
        }

        public int peak() {
            if (index < 0) {
                throw new IndexOutOfBoundsException("stack is null");
            }
            int tmp = index - 1;
            return arr[tmp];
        }
    }

    public static class ArrayQueue {

        int[] arr = null;
        int size = 0;
        int start = 0;
        int end = 0;

        private ArrayQueue(int len) {
            arr = new int[len];
        }

        public void push(int i) {
            if (size == arr.length) {
                throw new IndexOutOfBoundsException("queue is full");
            }
            /*if (end == arr.length) {
                end = 0;
            }*/
            end = end == arr.length - 1 ? 0 : ++end;
            arr[end] = i;
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new IndexOutOfBoundsException("queue is null");
            }
            if (start == arr.length) {
                start = 0;
            }

            start = start == arr.length - 1 ? 0 : ++start;
            size--;
            return arr[start];
        }

        public int peak() {
            if (size == 0) {
                throw new IndexOutOfBoundsException("queue is null");
            }
            return arr[start];
        }

    }
}
