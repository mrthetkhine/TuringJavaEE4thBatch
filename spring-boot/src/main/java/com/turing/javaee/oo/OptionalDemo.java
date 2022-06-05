package com.turing.javaee.oo;

import java.util.Optional;

public class OptionalDemo {
	static String toUpper(String str)
	{
		return str.toUpperCase();
	}
	static String appendHi(String str)
	{
		return "Hi " + str;
	}
	
	public static void main(String[]args)
	{
		/*
		String str = null;
		str = toUpper(str);
		str = appendHi(str);
		System.out.println("Str "+ str);
		*/
		
		Optional<String> strOpt = Optional.empty();
		
		String result = strOpt.map(str-> toUpper(str))
			  .map(str-> appendHi(str))
			  .orElse("Empty String");
		System.out.println("Result "+result);
		
	}
}
