package com.turing.javaee.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.LoggerFactory;

interface MyService
{
	int getSomething();
}
class MyServiceImpl implements MyService
{

	@Override
	public int getSomething() {
		System.out.println("Get someting called return 100");
		return 100;
	}
	
}
class LoggingHandler implements InvocationHandler {

	private Object invocationTarget;

	  public LoggingHandler(Object invocationTarget) {
	    this.invocationTarget = invocationTarget;
	  }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Logging handler Invoked method: {}"+ method.getName());
		method.invoke(invocationTarget, args);
	    return 42;
	}
}
public class ProxyDemo {
	public static void main(String[]args)
	{
		MyService service = new MyServiceImpl();

	    // Create the proxy
		MyService proxy = (MyService) 
	        Proxy.newProxyInstance(MyService.class.getClassLoader(), 
	          service.getClass().getInterfaces(),
	          new LoggingHandler(service));

	    // Invoke the target instance method through the proxy
	    int result = proxy.getSomething();

	    System.out.println("Result: " + result);
	}
}
