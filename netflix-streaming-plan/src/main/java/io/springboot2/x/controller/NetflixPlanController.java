package io.springboot2.x.controller;

import io.springboot2.x.domain.NetflixPlan;
import io.springboot2.x.dto.NetflixPlanDTO;
import io.springboot2.x.service.INetflixPlanService;
import io.springboot2.x.service.INetflixPlanService2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NetflixPlanController {

    @Autowired
    private INetflixPlanService2 service2;

    @Autowired
    private INetflixPlanService service;

    @GetMapping(value = "/getAllPlans",produces = {"application/json"})
    public ResponseEntity<List<NetflixPlanDTO>> getAllNetflixPlans(){
        List<NetflixPlanDTO> netflixPlanDTO=service.getAllPlans();
        return new ResponseEntity<List<NetflixPlanDTO>>(netflixPlanDTO, HttpStatus.OK);
    }
    @GetMapping(value = "/getSpecificPlan/{id}",produces = {"application/json"})
    public ResponseEntity<Object> getSpecificPlan(@PathVariable("id") String id){
        NetflixPlanDTO netflixPlanDTO=service.getSpecificPlan(id);
        if(netflixPlanDTO.getPlanId()==null){
            return new ResponseEntity<>("Sorry..,This id is not exist...", HttpStatus.OK);
        }
        return new ResponseEntity<>(netflixPlanDTO, HttpStatus.OK);
    }
    @DeleteMapping("/plan/delete")
    public ResponseEntity<String> deleteNetflixPlanById(@RequestParam String id){
        boolean flag=service.deleteNetflixPlanById(id);
        if(flag==true) {
            return ResponseEntity.ok("Plan is deleted from database...");

        }
        return ResponseEntity.ok("Id is doesn't exist!...");
    }
    @PostMapping("/plan/add")
    public ResponseEntity<String> addNetflixPlan(@RequestBody NetflixPlanDTO netflixPlanDTO){
        boolean flag=service.addNetflixPlan(netflixPlanDTO);
        if(flag==true) {
            return ResponseEntity.ok("Plan is added to database...");
        }
        return ResponseEntity.ok("Id is alredy exist!...");
    }
    @PutMapping(value = "/plan/update", consumes = { "application/json" })
    public ResponseEntity<String> updateNetflixPlan(@RequestBody  NetflixPlanDTO netflixPlanDTO){
        boolean flag=service.updateNetflixPlan(netflixPlanDTO);
        if(flag==true) {
            return ResponseEntity.ok("Plan is updated in database...");
        }
        return ResponseEntity.ok("Id is doesn't exist!...");
    }
    @GetMapping(value = "/plan/byName",produces = {"application/json"})
    public ResponseEntity<List<NetflixPlanDTO>> byNetflixPlanNameLikeCriteria(@RequestParam String search){
        List<NetflixPlan> netflixPlanList = service2.byNetflixPlanNameLikeCriteria(search);
        List<NetflixPlanDTO> netflixPlanDTOList = new ArrayList<>();
        netflixPlanList.forEach(netflixPlan -> {
            NetflixPlanDTO netflixPlanDTO = new NetflixPlanDTO();
            BeanUtils.copyProperties(netflixPlan, netflixPlanDTO);
            netflixPlanDTOList.add(netflixPlanDTO);
        });
        return new ResponseEntity<List<NetflixPlanDTO>>(netflixPlanDTOList, HttpStatus.OK);
    }
    @GetMapping(value = "/plan/byPrice",produces = {"application/json"})
    public ResponseEntity<List<NetflixPlanDTO>> byNetflixPlanPriceLikeCriteria(@RequestParam String search){
        List<NetflixPlan> netflixPlanList = service2.byNetflixPlanPriceLikeCriteria(search);
        List<NetflixPlanDTO> netflixPlanDTOList = new ArrayList<>();
        netflixPlanList.forEach(netflixPlan -> {
            NetflixPlanDTO netflixPlanDTO = new NetflixPlanDTO();
            BeanUtils.copyProperties(netflixPlan, netflixPlanDTO);
            netflixPlanDTOList.add(netflixPlanDTO);
        });
        return new ResponseEntity<List<NetflixPlanDTO>>(netflixPlanDTOList, HttpStatus.OK);
    }
}
