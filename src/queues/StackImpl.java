package queues;

class Stack {
    int[] arr;
    int size;
    int top;

    Stack(int n) {
        this.arr = new int[n];
        this.size = n;
        this.top = -1;
    }

    void push(int x) {
        if (top < size - 1) {
            top++;
            arr[top] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    int pop() {
        if (top >= 0) {
            int x = arr[top];
            top--;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    int peek() {
        if (top >= 0)
            return arr[top];
        else
            System.out.println("Stack Underflow");
        return 0;
    }

    int search(int x) {
        for (int i = 0; i <= top; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class StackImpl {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println();
        int search = stack.search(3);
        System.out.println("3 is present at "+search);
        int peek = stack.peek();
        System.out.println("peek = " + peek);
        int popedElem = stack.pop();
        System.out.println("popedElem = " + popedElem);
        System.out.println("After pop");
        stack.print();
        System.out.println(stack.isEmpty());

    }
}
