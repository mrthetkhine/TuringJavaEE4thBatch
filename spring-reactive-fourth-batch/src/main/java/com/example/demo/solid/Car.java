package com.example.demo.solid;


class DieselEngine extends Engine
{
	public void start()
	{
		System.out.println("DieselEngine start");
	}
}
class SolarEngine extends Engine
{
	public void start()
	{
		System.out.println("SolarEngine start");
	}
}
public class Car {
	Engine engine;
	
	
	public Car(Engine engine)
	{
		this.engine = engine;
	}
	public void start()
	{
		System.out.println("Car start");
		this.engine.start();
	}
	public int getMile()
	{
		return this.engine.getMile();
	}
}
