package ml.aicode.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("ml.aicode.microservices.currencyconversionservice")
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	
	/*@Bean
	public ServerList<Server> ribbonServerList(){
		StaticServerList<Server> staticServerList = new StaticServerList<>(new Server("localhost",8000),new Server("localhost",8001),new Server("localhost",8002));
		return staticServerList;
	}*/
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
