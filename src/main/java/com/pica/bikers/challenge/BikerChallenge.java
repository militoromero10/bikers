package com.pica.bikers.challenge;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "biker_challenge", indexes = {
        @Index(name = "biker_idx", columnList = "biker_id"),
        @Index(name = "challenge_idx", columnList = "challenge_id")
})
public class BikerChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bikerId;
    private UUID challengeId;
    private Long creditNumber;
    private BikerChallengeStatus bikerChallengeStatus;
    private Timestamp creationDate;
}
