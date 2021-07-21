package com.springliveproject.sm.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class StudentInitializer  implements WebApplicationInitializer
{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException 
	{

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext() ;
		webApplicationContext.register(StudentConfigurationFile.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

		ServletRegistration.Dynamic context   =  servletContext.addServlet("StudentDispatcherServlet", dispatcherServlet);
		context.addMapping("/");
		context.setLoadOnStartup(1);
	}

}
