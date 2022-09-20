package com.example.demo.tdd;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SatckTest {
	Stack stack = new Stack();
	
	@Test
	void emptyStackSizeShouldBeZero()
	{
		int size = stack.size();
		
		assertEquals(0, size);
		
	}
	@Test
	void sizeShoudlBeIncreasedWhenPush() throws StackOverflowException
	{
		int originalSize = stack.size();
		
		stack.push(10);
		
		int currentStackSize = stack.size();
		assertEquals( originalSize+1,currentStackSize);
	}
	@Test
	void sizeShoudlBeTwoWhenPushTwoTime() throws StackOverflowException
	{
		int originalSize = stack.size();
		
		stack.push(10);
		stack.push(20);
		
		int currentStackSize = stack.size();
		assertEquals( originalSize+2,currentStackSize);
	}
	@Test
	void popShouldGetLatestElementedPushIntoStack()throws StackEmptyException, StackOverflowException
	{
	
		stack.push(10);
		int element = stack.pop();
		int currentStackSize = stack.size();
		
		assertEquals( 10,element);
		assertEquals( 0,currentStackSize);
	}
	
	@Test 
	void shouldGetReverseOrderWhenPop() throws StackEmptyException, StackOverflowException
	{
		for(int i=0;i< 10;i++)
		{
			stack.push(i);
		}
		assertEquals(10,stack.size());
		
		for(int i=9;i>=0;i--)
		{
			int element = stack.pop();
			assertEquals(i,element);
		}
	}
	@Test
	void popTwoElementStack()throws StackEmptyException, StackOverflowException
	{
	
		stack.push(10);
		stack.push(20);
		
		int firstPop= stack.pop();
		int secondPop = stack.pop();
		
		int currentStackSize = stack.size();
		
		assertEquals( 20,firstPop);
		assertEquals( 10,secondPop);
		assertEquals( 0,currentStackSize);
	}
	@Test
	void stackShouldThrowStackOverflowExceptionWhenFull()
	{
		StackOverflowException exception = assertThrows(StackOverflowException.class, ()->{
			for(int i=0;i<11;i++)
			{
				stack.push(i);
			}
		});
		assertEquals(Stack.STACK_IS_OVERFLOW,exception.getMessage());
	}
	
	@Test
	void popShouldThrowEmptyStackExceptionWhenStackIsEmpty()
	{
		StackEmptyException exception = assertThrows(StackEmptyException.class, ()->{
			stack.pop();
		});
		assertEquals(Stack.STACK_IS_EMPTY,exception.getMessage());
	}
	@Test
	void popShouldThrowEmptyStackExceptionWhenPopIsMoreThanPush() throws StackOverflowException
	{
		stack.push(10);
		stack.push(20);
		
		StackEmptyException exception = assertThrows(StackEmptyException.class, ()->{
			stack.pop();
			stack.pop();
			stack.pop();
		});
		assertEquals(Stack.STACK_IS_EMPTY,exception.getMessage());
	}
}
