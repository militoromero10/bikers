package com.pica.bikers.challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikerChallengeRepository extends JpaRepository<BikerChallenge, Long> {

    @Query(nativeQuery = true, value = "SELECT SUM(bc.credit_number) FROM biker_challenge bc WHERE bc.biker_id = ?1")
    Long totalCredits(Long bikerId);

    List<BikerChallenge> findAllByBikerId(Long id);
}
