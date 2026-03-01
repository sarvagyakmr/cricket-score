package com.cricket.server.controller;

import com.cricket.server.entity.MatchResult;
import com.cricket.server.service.MatchResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-results")
public class MatchResultController {

    private final MatchResultService matchResultService;

    public MatchResultController(MatchResultService matchResultService) {
        this.matchResultService = matchResultService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResult> getMatchResultById(@PathVariable(name = "id") Long id) {
        return matchResultService.getMatchResultById(id)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}