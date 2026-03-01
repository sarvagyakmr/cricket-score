package com.cricket.server.controller;

import com.cricket.server.entity.MatchPlayer;
import com.cricket.server.service.MatchPlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-players")
public class MatchPlayerController {

    private final MatchPlayerService matchPlayerService;

    public MatchPlayerController(MatchPlayerService matchPlayerService) {
        this.matchPlayerService = matchPlayerService;
    }

    @PostMapping
    public ResponseEntity<MatchPlayer> createMatchPlayer(@RequestBody MatchPlayer matchPlayer) {
        MatchPlayer createdMatchPlayer = matchPlayerService.createMatchPlayer(matchPlayer);
        return new ResponseEntity<>(createdMatchPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchPlayer> getMatchPlayerById(@PathVariable(name = "id") Long id) {
        return matchPlayerService.getMatchPlayerById(id)
                .map(matchPlayer -> new ResponseEntity<>(matchPlayer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}