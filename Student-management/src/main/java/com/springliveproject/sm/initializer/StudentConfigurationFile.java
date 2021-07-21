package com.springliveproject.sm.initializer;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.springliveproject"})
public class StudentConfigurationFile implements WebMvcConfigurer
{
	   @Bean
        public InternalResourceViewResolver viewResolver()
        {
        	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        	viewResolver.setPrefix("/WEB-INF/view/");
        	viewResolver.setSuffix(".jsp");
        	
        	return viewResolver;
        }
	   
	@Bean
	   public JdbcTemplate jdbcTemplate()
	   {
		   JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		   
		   return jdbcTemplate;
	   }
	   
	   @Bean
	   public DataSource getDataSource()
	   {
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                
                dataSource.setUsername("Local");
                dataSource.setPassword("local");
                dataSource.setUrl("jdbc:oracle:thin:@DESKTOP-2P8DALP:1522:xe");
                dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
                
                return dataSource ;
	   }
	   
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) 
	   {
		       registry. addResourceHandler("/resources/**") . addResourceLocations("/resources/");
		       
		       registry. addResourceHandler("/images/**") . addResourceLocations("/resources/images/");
	   }
	   
	   @Bean
	   public MessageSource messageSource()
	   {
		   ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		   messageSource.setBasename("Message");
		   
		   return messageSource;
	   }
	   
	   @Bean
	   public LocalValidatorFactoryBean validator()
	   {
		  LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		  localValidatorFactoryBean.setValidationMessageSource(messageSource());
		  
		  return localValidatorFactoryBean;
	   }
	   
	   public Validator getValidator()
	   {
		   return validator();
	   }
}
