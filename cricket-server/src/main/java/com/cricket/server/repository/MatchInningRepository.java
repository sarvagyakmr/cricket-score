package com.cricket.server.repository;

import com.cricket.server.entity.MatchInning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchInningRepository extends JpaRepository<MatchInning, Long> {
    List<MatchInning> findByMatchId(Long matchId);
}