/*
 * Configuration Class
 */
package com.metacube.Parking.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.Parking.utils.ValidationFilter;

@Configuration
public class Config {

	@Bean
	public FilterRegistrationBean<ValidationFilter> validationFilter(){
	    FilterRegistrationBean<ValidationFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new ValidationFilter());
	    registrationBean.addUrlPatterns("/HomePage",
	    		"/EditPage",
	    		"/FileUpload",
	    		"/FriendPage",
	    		"/FriendProfile"
	    		);
	         
	    return registrationBean;    
	}
}
