package com.cricket.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_id_1", nullable = false)
    private Long teamId1;

    @Column(name = "team_id_2", nullable = false)
    private Long teamId2;

    @Column(name = "match_result_id")
    private Long matchResultId;

    public Match() {
    }

    public Match(Long teamId1, Long teamId2) {
        this.teamId1 = teamId1;
        this.teamId2 = teamId2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId1() {
        return teamId1;
    }

    public void setTeamId1(Long teamId1) {
        this.teamId1 = teamId1;
    }

    public Long getTeamId2() {
        return teamId2;
    }

    public void setTeamId2(Long teamId2) {
        this.teamId2 = teamId2;
    }

    public Long getMatchResultId() {
        return matchResultId;
    }

    public void setMatchResultId(Long matchResultId) {
        this.matchResultId = matchResultId;
    }
}