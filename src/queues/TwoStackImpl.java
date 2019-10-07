package queues;
class TwoStacks {
    int[] arr;
    int size;
    int top1;
    int top2;

    public TwoStacks(int n) {
        this.size = n;
        this.arr = new int[n];
        this.top1 = -1;
        this.top2 = size;
    }

    void push1(int x){
        if(top1 < top2 -1){
            top1++;
            arr[top1]=x;
        }else{
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    void push2(int x){
        if(top1 < top2 - 1){
            top2--;
            arr[top2] = x;
        }else
            System.out.println("Stack Overflow");
    }

    int pop1(){
        if(top1 >=0){
            int x = arr[top1];
            top1--;
            return x;
        }else{
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop2(){
        if(top2 < size){
            int x = arr[top2];
            top2++;
            return x;
        }else{
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }
}


public class TwoStackImpl {
    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(5);
        twoStacks.push1(5);
        twoStacks.push2(10);
        twoStacks.push2(15);
        twoStacks.push1(11);
        twoStacks.push2(7);

        System.out.println("Popped element from stack1 is "+twoStacks.pop1());

        twoStacks.push2(40);
        System.out.println("Popped element from stack2 is "+twoStacks.pop2());

    }
}
