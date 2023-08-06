package com.tony.inscribe.repository;

import com.tony.inscribe.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonLoginRepo extends JpaRepository<Person,Integer> {


    Person findByEmail(String username);
}
