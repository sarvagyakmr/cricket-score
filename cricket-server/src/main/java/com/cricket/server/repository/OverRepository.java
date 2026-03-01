package com.cricket.server.repository;

import com.cricket.server.entity.Over;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OverRepository extends JpaRepository<Over, Long> {
    
    Optional<Over> findFirstByInningIdAndBallsDoneLessThanOrderByOverNumberAsc(Long inningId, Integer ballsDone);
    
    Optional<Over> findFirstByInningIdOrderByOverNumberDesc(Long inningId);
}