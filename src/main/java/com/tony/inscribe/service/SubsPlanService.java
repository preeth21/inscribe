package com.tony.inscribe.service;

import com.tony.inscribe.model.SubsPlan;
import com.tony.inscribe.repository.SubsPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsPlanService {

    @Autowired
    private SubsPlanRepo subsPlanRepo;
    public List<SubsPlan> getPlans() {
        return subsPlanRepo.findAll();
    }
}
