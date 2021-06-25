package com.sophosolutions.generalcodilityreport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sophosolutions.generalcodilityreport.model.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {

}
