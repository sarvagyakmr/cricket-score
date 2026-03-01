package com.cricket.server.entity;

import com.cricket.server.enums.BallType;
import jakarta.persistence.*;

@Entity
@Table(name = "balls")
public class Ball {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "over_id", nullable = false)
    private Long overId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ball_type", nullable = false)
    private BallType ballType;

    @Column(name = "batter_run", nullable = false)
    private Integer batterRun = 0;

    @Column(name = "extra_run", nullable = false)
    private Integer extraRun = 0;

    @Column(name = "total_runs", nullable = false)
    private Integer totalRuns = 0;

    @Column(name = "batter_id", nullable = false)
    private Long batterId;

    public Ball() {
    }

    public Ball(Long overId, BallType ballType, Integer batterRun, Integer extraRun, Integer totalRuns, Long batterId) {
        this.overId = overId;
        this.ballType = ballType;
        this.batterRun = batterRun;
        this.extraRun = extraRun;
        this.totalRuns = totalRuns;
        this.batterId = batterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOverId() {
        return overId;
    }

    public void setOverId(Long overId) {
        this.overId = overId;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public Integer getBatterRun() {
        return batterRun;
    }

    public void setBatterRun(Integer batterRun) {
        this.batterRun = batterRun;
    }

    public Integer getExtraRun() {
        return extraRun;
    }

    public void setExtraRun(Integer extraRun) {
        this.extraRun = extraRun;
    }

    public Integer getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(Integer totalRuns) {
        this.totalRuns = totalRuns;
    }

    public Long getBatterId() {
        return batterId;
    }

    public void setBatterId(Long batterId) {
        this.batterId = batterId;
    }
}