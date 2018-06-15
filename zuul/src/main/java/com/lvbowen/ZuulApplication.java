package com.lvbowen;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//import com.lvbowen.filter.AccessFilter;
//import com.lvbowen.filter.UuidFilter;
//import com.lvbowen.filter.ValidateFilter;
import com.lvbowen.filter.ErrorFilter;
import com.lvbowen.filter.FirstFilter;
import com.lvbowen.filter.ResultFilter;
import com.lvbowen.filter.SecondFilter;

@EnableZuulProxy
@EnableEurekaClient
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public ResultFilter resultFilter() {
		return new ResultFilter();
	}

	@Bean
	public FirstFilter firstFilter() {
		return new FirstFilter();
	}

	@Bean
	public SecondFilter secondFilter() {
		return new SecondFilter();
	}

}
