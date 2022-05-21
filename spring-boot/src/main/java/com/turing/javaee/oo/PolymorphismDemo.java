package com.turing.javaee.oo;
class Human
{
	public void work()
	{
		System.out.println("Human Work");
	}
}
class Teacher extends Human
{
	public void work()
	{
		System.out.println("Teacher teach");
	}
}
class Doctor extends Human
{
	public void work()
	{
		System.out.println("Doctor treat patient");
	}
}

public class PolymorphismDemo {
	public static void main(String[]args)
	{
		Human h = new Teacher();
		h.work();
		
		h = new Doctor();
		h.work();
	}
}
