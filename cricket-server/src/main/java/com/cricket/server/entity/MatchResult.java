package com.cricket.server.entity;

import com.cricket.server.enums.MatchEndState;
import jakarta.persistence.*;

@Entity
@Table(name = "match_results")
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "end_state", nullable = false)
    private MatchEndState endState;

    @Column(name = "winning_team_id")
    private Long winningTeamId;

    @Column(name = "comment")
    private String comment;

    public MatchResult() {
    }

    public MatchResult(MatchEndState endState, Long winningTeamId, String comment) {
        this.endState = endState;
        this.winningTeamId = winningTeamId;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatchEndState getEndState() {
        return endState;
    }

    public void setEndState(MatchEndState endState) {
        this.endState = endState;
    }

    public Long getWinningTeamId() {
        return winningTeamId;
    }

    public void setWinningTeamId(Long winningTeamId) {
        this.winningTeamId = winningTeamId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}