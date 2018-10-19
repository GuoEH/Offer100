package com.offer;

import com.offer.datastruct.Queueable;

import java.util.Stack;

/**
 * Page68:面试题9：用两个栈实现队列
 */
public class Interview9 implements Queueable<Integer> {
    public static void main(String[] args) {
        Interview9 interview9 = new Interview9();
        interview9.add(1);
        interview9.add(2);

        System.out.println(interview9.offer());
        System.out.println(interview9.offer());

        interview9.add(3);
        interview9.add(4);

        System.out.println(interview9.offer());

        interview9.add(5);

        System.out.println(interview9.offer());
        System.out.println(interview9.offer());
        System.out.println(interview9.offer());
        System.out.println(interview9.offer());
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Interview9() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    @Override
    public void add(Integer integer) {
        stack1.push(integer);
    }

    @Override
    public Integer offer() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                Integer top = stack1.pop();
                stack2.push(top);
            }
        }
        if (stack2.size() == 0) {
            return null;
        }
        Integer first = stack2.pop();
        return first;
    }
}
