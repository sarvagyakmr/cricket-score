package com.cricket.server.service;

import com.cricket.server.entity.MatchResult;
import com.cricket.server.repository.MatchResultRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchResultService {

    private final MatchResultRepository matchResultRepository;

    public MatchResultService(MatchResultRepository matchResultRepository) {
        this.matchResultRepository = matchResultRepository;
    }

    public MatchResult saveMatchResult(MatchResult matchResult) {
        return matchResultRepository.save(matchResult);
    }

    public Optional<MatchResult> getMatchResultById(Long id) {
        return matchResultRepository.findById(id);
    }
}