package com.tony.inscribe.repository;

import com.tony.inscribe.model.SubsPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsPlanRepo extends JpaRepository<SubsPlan,Integer> {

}
