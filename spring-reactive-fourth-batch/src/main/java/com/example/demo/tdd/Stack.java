package com.example.demo.tdd;

public class Stack {

	public static final String STACK_IS_OVERFLOW = "Stack is overflow";

	public static final String STACK_IS_EMPTY = "Stack is empty";

	private static final int STACK_SIZE = 10;
	
	int index=0;
	int data[] = new int [STACK_SIZE];
	
	int size()
	{
		return index;
	}
	void push(int a)throws StackOverflowException
	{
		if(index == STACK_SIZE)
		{
			throw new StackOverflowException(STACK_IS_OVERFLOW);
		}
		this.data[index++] = a;
		
	}
	int pop() throws StackEmptyException
	{
		if(index==0)
		{
			throw new StackEmptyException(STACK_IS_EMPTY);
		}
		return this.data[--index];
	}
}
