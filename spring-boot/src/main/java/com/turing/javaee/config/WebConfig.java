package com.turing.javaee.config;

import java.util.Locale;

import javax.servlet.http.HttpServlet;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.turing.javaee.controller.BookController;
import com.turing.javaee.servletdemo.HelloWorldServlet;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
//@EnableSwagger2
public class WebConfig implements WebMvcConfigurer {
		@Bean	
	   public ServletRegistrationBean<HttpServlet> demoServlet() {
		   ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		   servRegBean.setServlet(new HelloWorldServlet());
		   servRegBean.addUrlMappings("/servlet/*");
		   servRegBean.setLoadOnStartup(1);
		   return servRegBean;
	   }
		
	  @Bean
	  public LocaleResolver localeResolver() {
	      SessionLocaleResolver slr = new SessionLocaleResolver();
	      slr.setDefaultLocale(Locale.US);
	      slr.setLocaleAttributeName("session.current.locale");
	      slr.setTimeZoneAttributeName("session.current.timezone");
	      return slr;
	  }
	  @Bean
	  public LocaleChangeInterceptor localeChangeInterceptor() {
	      LocaleChangeInterceptor localeChangeInterceptor 
	                      = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("language");
	      log.info("Localed change");
	      return localeChangeInterceptor;
	  }
	  
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(localeChangeInterceptor());
	  }
	  @Bean("messageSource")
	  public MessageSource messageSource() {
	      ResourceBundleMessageSource messageSource = 
	               new ResourceBundleMessageSource();
	      messageSource.setBasenames("language/messages");
	      messageSource.setDefaultEncoding("UTF-8");
	      return messageSource;
	  }
	  /*
	  @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.regex("/api/.*"))
	                .build();

	    }
	    */
}
