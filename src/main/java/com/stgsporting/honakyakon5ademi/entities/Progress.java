package com.stgsporting.honakyakon5ademi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Setter
@Getter
@Entity
@Immutable
@Table(name = "progress")
public class Progress {
    @Id
    @Column(name = "khedma_id")
    private Long khedmaId;

    @Column(name = "total_responses")
    private int totalResponses;

    @Column(name = "today_responses")
    private int todayResponses;
}
