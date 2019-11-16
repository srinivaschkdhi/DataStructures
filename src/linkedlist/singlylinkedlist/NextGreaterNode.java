package linkedlist.singlylinkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodeVals = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            nodeVals.add(curr.data);
            curr = curr.next;
        }

        int[] outputArr = new int[nodeVals.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nodeVals.size(); i++) {
            while (!stack.isEmpty() && nodeVals.get(i) > nodeVals.get(stack.peek())) {
                outputArr[stack.pop()] = nodeVals.get(i);
            }
            stack.push(i);
        }

        return outputArr;
    }
}
