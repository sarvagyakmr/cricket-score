package com.cricket.server.entity;

import com.cricket.server.enums.InningState;
import jakarta.persistence.*;

@Entity
@Table(name = "match_innings")
public class MatchInning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "match_id", nullable = false)
    private Long matchId;

    @Column(name = "inning_name", nullable = false)
    private String inningName;

    @Enumerated(EnumType.STRING)
    @Column(name = "inning_state", nullable = false)
    private InningState inningState;

    @Column(name = "total_runs", nullable = false)
    private Integer totalRuns = 0;

    @Column(name = "extras", nullable = false)
    private Integer extras = 0;

    @Column(name = "wickets", nullable = false)
    private Integer wickets = 0;

    @Column(name = "number_of_overs", nullable = false)
    private Integer numberOfOvers = 0;

    @Column(name = "batting_team_id", nullable = false)
    private Long battingTeamId;

    public MatchInning() {
    }

    public MatchInning(Long matchId, String inningName, InningState inningState, Long battingTeamId) {
        this.matchId = matchId;
        this.inningName = inningName;
        this.inningState = inningState;
        this.battingTeamId = battingTeamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getInningName() {
        return inningName;
    }

    public void setInningName(String inningName) {
        this.inningName = inningName;
    }

    public InningState getInningState() {
        return inningState;
    }

    public void setInningState(InningState inningState) {
        this.inningState = inningState;
    }

    public Integer getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(Integer totalRuns) {
        this.totalRuns = totalRuns;
    }

    public Integer getExtras() {
        return extras;
    }

    public void setExtras(Integer extras) {
        this.extras = extras;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Integer getNumberOfOvers() {
        return numberOfOvers;
    }

    public void setNumberOfOvers(Integer numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
    }

    public Long getBattingTeamId() {
        return battingTeamId;
    }

    public void setBattingTeamId(Long battingTeamId) {
        this.battingTeamId = battingTeamId;
    }
}