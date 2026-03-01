package com.cricket.server.service;

import com.cricket.server.entity.Ball;
import com.cricket.server.entity.MatchInning;
import com.cricket.server.entity.Over;
import com.cricket.server.enums.BallType;
import com.cricket.server.repository.BallRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BallService {

    private final BallRepository ballRepository;
    private final OverService overService;
    private final MatchInningService matchInningService;

    public BallService(BallRepository ballRepository, OverService overService, MatchInningService matchInningService) {
        this.ballRepository = ballRepository;
        this.overService = overService;
        this.matchInningService = matchInningService;
    }

    @Transactional
    public Ball createBall(Long inningId, Long bowlerId, BallType ballType, Integer batterRun, 
                           Integer extraRun, Integer totalRuns, Long batterId) {
        
        // Find or create over
        Over over = findOrCreateOver(inningId, bowlerId);
        
        // Create the ball
        Ball ball = new Ball(over.getId(), ballType, batterRun, extraRun, totalRuns, batterId);
        Ball savedBall = ballRepository.save(ball);
        
        // Increment ballsDone if ball type is NORMAL
        if (ballType == BallType.NORMAL) {
            over.setBallsDone(over.getBallsDone() + 1);
            overService.save(over);
        }
        
        // Update match inning stats
        updateMatchInningStats(inningId, totalRuns, extraRun, ballType);
        
        return savedBall;
    }

    private Over findOrCreateOver(Long inningId, Long bowlerId) {
        // Find over with less than 6 balls done
        Optional<Over> existingOver = overService.findOverWithLessThanSixBalls(inningId);
        
        if (existingOver.isPresent()) {
            return existingOver.get();
        }
        
        // Create new over if no over with less than 6 balls exists
        return overService.createNewOver(inningId, bowlerId);
    }

    private void updateMatchInningStats(Long inningId, Integer totalRuns, Integer extraRun, BallType ballType) {
        Optional<MatchInning> inningOpt = matchInningService.getMatchInningById(inningId);
        
        if (inningOpt.isPresent()) {
            MatchInning inning = inningOpt.get();
            
            // Increment total runs
            inning.setTotalRuns(inning.getTotalRuns() + totalRuns);
            
            // Increment extras
            inning.setExtras(inning.getExtras() + extraRun);
            
            // Increment wickets if ball type is WICKET
            if (ballType == BallType.WICKET) {
                inning.setWickets(inning.getWickets() + 1);
            }
            
            matchInningService.createMatchInning(inning);
        }
    }

    public Optional<Ball> getBallById(Long id) {
        return ballRepository.findById(id);
    }
}