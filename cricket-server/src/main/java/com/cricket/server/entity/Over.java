package com.cricket.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "overs")
public class Over {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inning_id", nullable = false)
    private Long inningId;

    @Column(name = "over_number", nullable = false)
    private Integer overNumber;

    @Column(name = "bowler_id", nullable = false)
    private Long bowlerId;

    @Column(name = "balls_done", nullable = false)
    private Integer ballsDone = 0;

    public Over() {
    }

    public Over(Long inningId, Integer overNumber, Long bowlerId) {
        this.inningId = inningId;
        this.overNumber = overNumber;
        this.bowlerId = bowlerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInningId() {
        return inningId;
    }

    public void setInningId(Long inningId) {
        this.inningId = inningId;
    }

    public Integer getOverNumber() {
        return overNumber;
    }

    public void setOverNumber(Integer overNumber) {
        this.overNumber = overNumber;
    }

    public Long getBowlerId() {
        return bowlerId;
    }

    public void setBowlerId(Long bowlerId) {
        this.bowlerId = bowlerId;
    }

    public Integer getBallsDone() {
        return ballsDone;
    }

    public void setBallsDone(Integer ballsDone) {
        this.ballsDone = ballsDone;
    }
}