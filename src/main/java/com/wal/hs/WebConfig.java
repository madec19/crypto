package com.wal.hs;

import java.util.Arrays;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.model.wadl.WadlGenerator;
import org.apache.cxf.jaxrs.spring.JaxRsConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.wal.hs.crypto.service.CryptoService;
import com.wal.hs.crypto.service.CryptoServiceImpl;

@Configuration
@Import(JaxRsConfig.class)
public class WebConfig {
	
	@Bean
	public ServletRegistrationBean cxfServlet()
	{
		ServletRegistrationBean registerBean = new ServletRegistrationBean(new CXFServlet(),"/api/*");
		return registerBean;
	}

	@Bean
	public Server server()
	{
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setServiceBean(service());
		endpoint.setAddress("/crypto");
		endpoint.getInInterceptors().add(loogingIn());
		endpoint.getOutInterceptors().add(loggingOut());
		endpoint.setProviders(Arrays.asList(provider(),wadlGenerator()));
		return endpoint.create();
	}

	@Bean
	public WadlGenerator wadlGenerator() {
		return new WadlGenerator();
	}
	@Bean
	public CryptoService service() {
		// TODO Auto-generated method stub
		return new CryptoServiceImpl();
	}

	@Bean
	public LoggingInInterceptor loggingOut() {
		LoggingInInterceptor in = new LoggingInInterceptor();
		in.setPrettyLogging(true);
		return in;
	}

	@Bean 
	public LoggingOutInterceptor loogingIn() {
		LoggingOutInterceptor out = new LoggingOutInterceptor();
		out.setPrettyLogging(true);
		return out;
	}

	@Bean
	public JacksonJsonProvider provider() {
		return new JacksonJsonProvider();
	}
}
