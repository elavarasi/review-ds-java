package com.review.ds.interviewbit.chapter5_linkedlist;
import java.util.Stack;

class Solution {
	
	public static void main(String args[]){
		
	}
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
    
	public void push(int x) {
		if(minStack.isEmpty()) {
			minStack.push(x);
			stack.push(x);
			return;
		} else {
			if( x <= minStack.peek()){
				minStack.push(x);
			}
			stack.push(x);
		}
    }

    public void pop() {
    	if(stack.isEmpty()) {
    		return;
    	}
    	if (stack.peek() == minStack.peek()) {
    		minStack.pop();
    		stack.pop();
    	} else {
    		stack.pop();
    	}      
    }

    public int top() {       
        if(stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek();    
        }              
    }

    public int getMin() {
    	if(minStack.isEmpty()) {
    		return -1;
    	} else {
    		return minStack.peek();	
    	}
    }
}
