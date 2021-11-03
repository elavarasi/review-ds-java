package com.review.DataStructureAlgorithm.educativeio.Graph;

import java.util.LinkedList;

public class Stack {
    private int size = 10;
    private int top = -1;

    private LinkedList stack;

    Stack(int size) {
        this.size = size;
        this.top = -1;
        stack = new LinkedList();
    }

    public void push(int data) {
        stack.add(top++, data);
    }

    public Object pop() {
        Object data =  stack.get(top);
        stack.remove(top);

        return data;
    }

    public int peek() {
        return (int) stack.get(top--);
    }


}
