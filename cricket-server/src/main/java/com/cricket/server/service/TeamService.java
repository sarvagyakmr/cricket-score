package com.cricket.server.service;

import com.cricket.server.entity.Team;
import com.cricket.server.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }
}