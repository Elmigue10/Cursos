package com.sophossolutions.ChallengeCodility.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sophossolutions.ChallengeCodility.model.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, String> {

}
