package com.turing.javaee.oo;
interface PaymentGateway
{
	abstract public void process();
	
}
class KBZGateway implements PaymentGateway
{
	public void process()
	{
		System.out.println("KBZ Gateway start");
	}
}
class CBGateway implements PaymentGateway
{
	public void process()
	{
		System.out.println("CB Gateway start");
	}
}
class MockGateway implements PaymentGateway
{
	public void process()
	{
		System.out.println("MockGateway start");
	}
}
class MPUPayment
{
	PaymentGateway gateway;
	MPUPayment(PaymentGateway gateway)
	{
		this.gateway = gateway;
	}
	
	void process()
	{
		System.out.println("MPU Payment start");
		this.gateway.process();
	}
}
public class DIExample {
	public static void main(String[]args)
	{
		PaymentGateway engine = new MockGateway();
		MPUPayment car = new MPUPayment(engine);
		car.process();
	}
}
