package com.cricket.server.service;

import com.cricket.server.entity.Match;
import com.cricket.server.entity.MatchInning;
import com.cricket.server.entity.MatchResult;
import com.cricket.server.enums.MatchEndState;
import com.cricket.server.repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchInningService matchInningService;
    private final MatchResultService matchResultService;

    public MatchService(MatchRepository matchRepository, 
                        MatchInningService matchInningService, 
                        MatchResultService matchResultService) {
        this.matchRepository = matchRepository;
        this.matchInningService = matchInningService;
        this.matchResultService = matchResultService;
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    @Transactional
    public MatchResult finishMatch(Long matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        List<MatchInning> innings = matchInningService.getInningsByMatchId(matchId);
        
        if (innings.size() < 2) {
            throw new RuntimeException("Match must have at least 2 innings to finish");
        }

        MatchInning inning1 = innings.get(0);
        MatchInning inning2 = innings.get(1);

        int runs1 = inning1.getTotalRuns();
        int runs2 = inning2.getTotalRuns();

        MatchEndState endState;
        Long winningTeamId = null;
        String comment;

        if (runs1 == runs2) {
            endState = MatchEndState.TIE;
            comment = "Match tied with " + runs1 + " runs each";
        } else {
            endState = MatchEndState.WIN;
            if (runs1 > runs2) {
                winningTeamId = inning1.getBattingTeamId();
                comment = "Team " + winningTeamId + " won by " + (runs1 - runs2) + " runs";
            } else {
                winningTeamId = inning2.getBattingTeamId();
                comment = "Team " + winningTeamId + " won by " + (runs2 - runs1) + " runs";
            }
        }

        MatchResult matchResult = new MatchResult(endState, winningTeamId, comment);
        MatchResult savedResult = matchResultService.saveMatchResult(matchResult);

        match.setMatchResultId(savedResult.getId());
        matchRepository.save(match);

        return savedResult;
    }
}