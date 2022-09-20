package com.example.demo.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.demo.solid.Car;
import com.example.demo.solid.Engine;

public class TestCar {

	
	@Test
	void startingCarShouldStartEngine()
	{
		Engine engine = Mockito.mock(Engine.class);
		
		when(engine.getMile()).thenReturn(200);
		
		Car car = new Car(engine);
		car.start();
		
		Mockito.verify(engine,atLeast(1)).start();
		int mile = car.getMile();
		assertEquals(200, mile);
	}
}
