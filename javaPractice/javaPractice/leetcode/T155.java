package leetcode;

import java.util.*;

public class T155 {
    Deque<Long> st;
    Long minVal;

    public T155() {
        st = new ArrayDeque<>();
        minVal = 0L;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            minVal = (long) val;
            st.push(0L);
        } else {
            st.push(val - minVal);
            if (val < minVal)
                minVal = (long) val;
        }
    }

    public void pop() {
        if (st.peek() < 0) {
            minVal = minVal - st.pop();
        } else {
            st.pop();
        }
    }

    public int top() {
        if (st.peek() < 0) {
            return minVal.intValue();
        } else {
            return (int) (st.peek() + minVal);
        }
    }

    public int getMin() {
        return minVal.intValue();
    }


    public static void main(String[] args) {


    }
}



//标答
class MinStack {

    private int[] stack;      // 存储栈元素
    private int[] minValues;  // 存储对应位置的最小值
    private int size;         // 当前栈元素数量
    private static final int INIT_CAPACITY = 10;  // 初始容量

    public MinStack() {
        stack = new int[INIT_CAPACITY];
        minValues = new int[INIT_CAPACITY];
        size = 0;
    }

    public void push(int val) {
        // 扩容判断
        if (size == stack.length) {
            int newCapacity = stack.length * 2;
            int[] newStack = new int[newCapacity];
            int[] newMin = new int[newCapacity];
            System.arraycopy(stack, 0, newStack, 0, size);
            System.arraycopy(minValues, 0, newMin, 0, size);
            stack = newStack;
            minValues = newMin;
        }

        stack[size] = val;
        // 计算当前最小值
        if (size == 0) {
            minValues[size] = val;
        } else {
            minValues[size] = Math.min(val, minValues[size - 1]);
        }
        size++;
    }

    public void pop() {
        if (size > 0) {
            size--;  // 直接减小size，无需实际删除元素
        }
    }

    public int top() {
        if (size > 0) {
            return stack[size - 1];
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int getMin() {
        if (size > 0) {
            return minValues[size - 1];
        }
        throw new IllegalStateException("Stack is empty");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
