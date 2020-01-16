package ml.aicode.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ml.aicode.microservices.limitsservice.bean.LimitConfiguration;



@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfiguration() {
		//return new LimitConfiguration(1000, 1);
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetriveConfiguration")
	public LimitConfiguration reteriveConfiguration() {
		throw new RuntimeException("Not available");
	}
	
	public LimitConfiguration fallbackRetriveConfiguration() {
		return new LimitConfiguration(888,0);
	}
}
