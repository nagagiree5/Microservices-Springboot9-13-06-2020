package io.springboot2.x.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.springboot2.x.dto.NetflixDevicesDTO;

@FeignClient("NETFLIX-STREAMING-DEVICE")
public interface IDeviceFeign {

	    @GetMapping(value = "/Netflix/devices/{phoneNor}",produces ={"application/json"})  
	    public ResponseEntity<List<NetflixDevicesDTO>> findByMobile(@PathVariable String phoneNor);
	   
}
