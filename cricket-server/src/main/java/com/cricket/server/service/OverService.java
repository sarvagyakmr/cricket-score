package com.cricket.server.service;

import com.cricket.server.entity.MatchInning;
import com.cricket.server.entity.Over;
import com.cricket.server.repository.OverRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OverService {

    private final OverRepository overRepository;
    private final MatchInningService matchInningService;

    public OverService(OverRepository overRepository, @Lazy MatchInningService matchInningService) {
        this.overRepository = overRepository;
        this.matchInningService = matchInningService;
    }

    public Over save(Over over) {
        return overRepository.save(over);
    }

    public Optional<Over> findById(Long id) {
        return overRepository.findById(id);
    }

    public Optional<Over> findOverWithLessThanSixBalls(Long inningId) {
        return overRepository.findFirstByInningIdAndBallsDoneLessThanOrderByOverNumberAsc(inningId, 6);
    }

    public Optional<Over> findLatestOver(Long inningId) {
        return overRepository.findFirstByInningIdOrderByOverNumberDesc(inningId);
    }

    @Transactional
    public Over createNewOver(Long inningId, Long bowlerId) {
        Optional<Over> latestOver = findLatestOver(inningId);
        int nextOverNumber = latestOver.map(over -> over.getOverNumber() + 1).orElse(1);
        
        Over newOver = new Over(inningId, nextOverNumber, bowlerId);
        newOver.setBallsDone(0);
        Over savedOver = overRepository.save(newOver);

        // Increment number of overs in match inning
        matchInningService.getMatchInningById(inningId).ifPresent(inning -> {
            inning.setNumberOfOvers(inning.getNumberOfOvers() + 1);
            matchInningService.createMatchInning(inning);
        });

        return savedOver;
    }
}