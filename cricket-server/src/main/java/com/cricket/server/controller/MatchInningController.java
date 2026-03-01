package com.cricket.server.controller;

import com.cricket.server.entity.MatchInning;
import com.cricket.server.service.MatchInningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-innings")
public class MatchInningController {

    private final MatchInningService matchInningService;

    public MatchInningController(MatchInningService matchInningService) {
        this.matchInningService = matchInningService;
    }

    @PostMapping
    public ResponseEntity<MatchInning> createMatchInning(@RequestBody MatchInning matchInning) {
        MatchInning createdMatchInning = matchInningService.createMatchInning(matchInning);
        return new ResponseEntity<>(createdMatchInning, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchInning> getMatchInningById(@PathVariable(name = "id") Long id) {
        return matchInningService.getMatchInningById(id)
                .map(matchInning -> new ResponseEntity<>(matchInning, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}