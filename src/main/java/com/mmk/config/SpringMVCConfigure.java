package com.mmk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mmk.common.convert.StringToDate;
import com.mmk.security.service.impl.APISecurityInterceptorAdapter;

@Configuration
public class SpringMVCConfigure  extends WebMvcConfigurerAdapter{


	
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new APISecurityInterceptorAdapter()).addPathPatterns("/api/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
    	StringToDate converter = new StringToDate();
    	registry.addConverter(converter);
    }
    
    
    
}
