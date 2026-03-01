package com.cricket.server.controller;

import com.cricket.server.entity.Match;
import com.cricket.server.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match createdMatch = matchService.createMatch(match);
        return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable(name = "id") Long id) {
        return matchService.getMatchById(id)
                .map(match -> new ResponseEntity<>(match, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<com.cricket.server.entity.MatchResult> finishMatch(@PathVariable(name = "id") Long id) {
        com.cricket.server.entity.MatchResult result = matchService.finishMatch(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}