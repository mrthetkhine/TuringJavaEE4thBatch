package com.turing.javaee.config;

import javax.servlet.http.HttpServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.turing.javaee.servletdemo.HelloWorldServlet;

@Configuration
public class WebConfig {
		@Bean	
	   public ServletRegistrationBean<HttpServlet> demoServlet() {
		   ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		   servRegBean.setServlet(new HelloWorldServlet());
		   servRegBean.addUrlMappings("/servlet/*");
		   servRegBean.setLoadOnStartup(1);
		   return servRegBean;
	   }
}
