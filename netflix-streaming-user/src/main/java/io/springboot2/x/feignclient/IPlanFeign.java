package io.springboot2.x.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.springboot2.x.dto.NetflixPlanDTO;

@FeignClient("NETFLIX-STREAMING-PLAN")
public interface IPlanFeign {
	
    @GetMapping(value ="/Netflix/getSpecificPlan/{id}",produces = {"application/json"})
    public NetflixPlanDTO getSpecificPlan(@PathVariable("id") String id);

}
