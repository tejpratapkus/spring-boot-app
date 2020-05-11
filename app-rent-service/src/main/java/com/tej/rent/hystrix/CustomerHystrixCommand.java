package com.tej.rent.hystrix;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.tej.model.customer.Customer;

public class CustomerHystrixCommand extends HystrixCommand<Customer>{
	
	private RestTemplate restTemplate;
	private int customerId;

	public CustomerHystrixCommand(RestTemplate restTemplate, int customerId) {
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.restTemplate = restTemplate;
		this.customerId = customerId;
	}

	@Override
	protected Customer run() throws Exception {
		return restTemplate.getForObject("http://customer/services/customers/" + customerId,
				Customer.class);
	}
	
	@Override
	protected Customer getFallback() {
		return new Customer();
		
	}

}
