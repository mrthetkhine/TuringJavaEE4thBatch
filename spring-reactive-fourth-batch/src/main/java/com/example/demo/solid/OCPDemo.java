package com.example.demo.solid;

public class OCPDemo {
	public static void main(String[]args)
	{
		Engine engine = new SolarEngine();
		Car car = new Car(engine);
		car.start();
	}
}
