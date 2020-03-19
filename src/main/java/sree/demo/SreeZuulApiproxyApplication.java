package sree.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import sree.demo.filters.ProxyFilter;
import sree.demo.filters.StartPreFilter;
import sree.demo.filters.StopPostFilter;

@EnableZuulProxy
@SpringBootApplication
public class SreeZuulApiproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SreeZuulApiproxyApplication.class, args);
	}

	@Bean
	public ProxyFilter proxyFilter() {
		return new ProxyFilter();
	}
	
	@Bean
	public StartPreFilter startPreFilter() {
		return new StartPreFilter();
	}
	
	@Bean
	public StopPostFilter stopPostFilter() {
		return new StopPostFilter();
	}
}
