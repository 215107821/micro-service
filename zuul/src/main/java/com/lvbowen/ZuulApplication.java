package com.lvbowen;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//import com.lvbowen.filter.AccessFilter;
//import com.lvbowen.filter.UuidFilter;
//import com.lvbowen.filter.ValidateFilter;
import com.lvbowen.filter.ErrorFilter;
import com.lvbowen.filter.ResultFilter;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

	// @Bean
	// public AccessFilter accessFilter() {
	// return new AccessFilter();
	// }
	//
	// @Bean
	// public RateLimitFilter rateLimiterFilter() {
	// return new RateLimitFilter();
	// }

	@Bean
	public ResultFilter resultFilter() {
		return new ResultFilter();
	}

	// @Bean
	// public UuidFilter uuidFilter() {
	// return new UuidFilter();
	// }
	//
	// @Bean
	// public ValidateFilter validateFilter() {
	// return new ValidateFilter();
	// }

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

}
