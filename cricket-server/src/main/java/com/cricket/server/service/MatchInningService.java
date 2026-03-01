package com.cricket.server.service;

import com.cricket.server.entity.MatchInning;
import com.cricket.server.repository.MatchInningRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchInningService {

    private final MatchInningRepository matchInningRepository;

    public MatchInningService(MatchInningRepository matchInningRepository) {
        this.matchInningRepository = matchInningRepository;
    }

    public MatchInning createMatchInning(MatchInning matchInning) {
        return matchInningRepository.save(matchInning);
    }

    public Optional<MatchInning> getMatchInningById(Long id) {
        return matchInningRepository.findById(id);
    }

    public java.util.List<MatchInning> getInningsByMatchId(Long matchId) {
        return matchInningRepository.findByMatchId(matchId);
    }
}