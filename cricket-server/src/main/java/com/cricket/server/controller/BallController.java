package com.cricket.server.controller;

import com.cricket.server.dto.CreateBallRequest;
import com.cricket.server.entity.Ball;
import com.cricket.server.service.BallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/balls")
public class BallController {

    private final BallService ballService;

    public BallController(BallService ballService) {
        this.ballService = ballService;
    }

    @PostMapping
    public ResponseEntity<Ball> createBall(@RequestBody CreateBallRequest request) {
        Ball ball = ballService.createBall(
                request.getInningId(),
                request.getBowlerId(),
                request.getBallType(),
                request.getBatterRun(),
                request.getExtraRun(),
                request.getTotalRuns(),
                request.getBatterId()
        );
        return new ResponseEntity<>(ball, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ball> getBallById(@PathVariable(name = "id") Long id) {
        return ballService.getBallById(id)
                .map(ball -> new ResponseEntity<>(ball, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}