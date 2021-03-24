package io.springboot2.x.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.springboot2.x.dto.NetflixDevicesDTO;
import io.springboot2.x.feignclient.IDeviceFeign;

@Service
public class UserCircuitBreaker {
	 
	
	/* For feign client */ 
	//private static final String DEVICE_URL="http://NETFLIX-STREAMING-DEVICE/Netflix/devices/{phoneNor}";
    // @Autowired  
    //@Qualifier("restTemplate2")
    //private RestTemplate restTemplate2;
    
    @Autowired
    private IDeviceFeign deviceFeign;
    
    

	@HystrixCommand(fallbackMethod = "getDevicesFallback")
	public List<NetflixDevicesDTO> getDevice(String phoneNor) {
		 System.out.println("--->Test1: getDevice() of circuritbreaker");
		 ParameterizedTypeReference<List<NetflixDevicesDTO>> typeRef = new ParameterizedTypeReference<List<NetflixDevicesDTO>>() {};
		 /* For feign client */ 
		 //ResponseEntity<List<NetflixDevicesDTO>> responseEntity=restTemplate2.exchange(DEVICE_URL, HttpMethod.GET,null,typeRef ,phoneNor);
		 
		 /*Here.., feign client */ 
		 ResponseEntity<List<NetflixDevicesDTO>> responseEntity=deviceFeign.findByMobile(phoneNor);
		 List<NetflixDevicesDTO> devicesConnected=responseEntity.getBody();
		
		return devicesConnected;
		
	}

	public List<NetflixDevicesDTO> getDevicesFallback(String phoneNor) {
		System.out.println("--->Test2: getDevicesFallback of circuritbreaker");
		return new ArrayList<>();
	}

}
