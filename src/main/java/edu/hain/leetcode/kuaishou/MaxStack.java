package edu.hain.leetcode.kuaishou;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxStack {


    private Stack<Integer> stack; // 主栈，用于存储所有元素
    private Stack<Integer> maxStack; // 辅助栈，用于存储栈中的最大元素

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        // 将元素压入主栈
        stack.push(x);
        // 如果辅助栈为空或者新元素大于等于辅助栈顶元素，则也将新元素压入辅助栈
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        // 如果主栈顶元素等于辅助栈顶元素，那么也需要从辅助栈中弹出
        if (stack.peek().equals(maxStack.peek())) {
            maxStack.pop();
        }
        // 弹出并返回主栈顶元素
        return stack.pop();
    }

    public int top() {
        // 返回主栈顶元素，不弹出
        return stack.peek();
    }

    public int peekMax() {
        // 返回辅助栈顶元素，即当前栈中的最大元素
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();
        Stack<Integer> tempStack = new Stack<>();
        // 从主栈中弹出元素，直到找到最大元素
        while (stack.peek() != max) {
            tempStack.push(stack.pop());
        }
        // 弹出最大元素
        stack.pop();
        // 将临时栈中的元素重新压入主栈
        while (!tempStack.isEmpty()) {
            int x = tempStack.pop();
            // 这里需要注意，重新压入的元素也需要判断是否要压入辅助栈
            if (maxStack.isEmpty() ||(!maxStack.isEmpty() && x >= maxStack.peek())) {
                maxStack.push(x);
            }
            stack.push(x);
        }
        return max;
    }
}
