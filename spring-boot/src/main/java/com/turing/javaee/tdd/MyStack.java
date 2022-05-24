package com.turing.javaee.tdd;

public class MyStack {
	
	static final int SIZE = 20;
	int stack[] = new int [SIZE];
	int top = -1;
	
	void push(int a)
	{
		stack[++top] = a;
	}
	int size()
	{
		return top+1;
	}
	int pop()
	{
		
		return this.stack[this.top--];
	}
}
