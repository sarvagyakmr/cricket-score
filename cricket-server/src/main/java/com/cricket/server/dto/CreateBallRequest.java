package com.cricket.server.dto;

import com.cricket.server.enums.BallType;

public class CreateBallRequest {
    
    private Long inningId;
    private Long bowlerId;
    private BallType ballType;
    private Integer batterRun;
    private Integer extraRun;
    private Integer totalRuns;
    private Long batterId;

    public Long getInningId() {
        return inningId;
    }

    public void setInningId(Long inningId) {
        this.inningId = inningId;
    }

    public Long getBowlerId() {
        return bowlerId;
    }

    public void setBowlerId(Long bowlerId) {
        this.bowlerId = bowlerId;
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