package com.tony.inscribe.controller;

import com.tony.inscribe.model.SubsPlan;
import com.tony.inscribe.service.SubsPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FetchSubs {

    @Autowired
    private SubsPlanService subsPlanService;

    @GetMapping("/getSubsPlan")
    public List<SubsPlan> getSubsPlan(){
       return subsPlanService.getPlans();
    }
}
