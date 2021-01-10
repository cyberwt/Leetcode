package stack.array;

import java.util.Stack;

/**
 * 两个栈，缩到一个栈时，进行的操作是相似的，
 *
 * if(x<= stack.peek()){stack.push(x)}
 *
 *
 * 8/11/20.
 */
public class _155_min_stack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public _155_min_stack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int pop = stack.pop();

        int top = minStack.peek();
        //等于的时候再出栈
        if (pop == top) {
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

// 同时
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}