package com.cricket.server.service;

import com.cricket.server.entity.MatchPlayer;
import com.cricket.server.repository.MatchPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchPlayerService {

    private final MatchPlayerRepository matchPlayerRepository;

    public MatchPlayerService(MatchPlayerRepository matchPlayerRepository) {
        this.matchPlayerRepository = matchPlayerRepository;
    }

    public MatchPlayer createMatchPlayer(MatchPlayer matchPlayer) {
        return matchPlayerRepository.save(matchPlayer);
    }

    public Optional<MatchPlayer> getMatchPlayerById(Long id) {
        return matchPlayerRepository.findById(id);
    }
}