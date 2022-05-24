package com.turing.javaee.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest {
	@Test
	public void testPush()
	{
		MyStack stack = new MyStack();
		int oldSize = stack.size();
		stack.push(100);
		
		assertEquals(oldSize + 1, stack.size());
	}
	@Test
	public void testPushTenElement()
	{
		MyStack stack = new MyStack();
		
		for(int i=0;i< 15;i++)
		{
			stack.push(100);
		}
			
		assertEquals(15, stack.size());
	}
	@Test
	public void testPopShouldDescreaseSizeByOne()
	{
		MyStack stack = new MyStack();
		
		stack.push(100);
		int size = stack.size();
		
		stack.pop();
		assertEquals(size-1, stack.size());
	}
	@Test
	public void testPopShouldReturnLastPushElement()
	{
		MyStack stack = new MyStack();
		
		stack.push(100);

		assertEquals(100, stack.pop());
	}
}
