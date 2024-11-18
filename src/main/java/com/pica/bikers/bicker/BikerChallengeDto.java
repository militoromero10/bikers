package com.pica.bikers.bicker;

import com.pica.bikers.challenge.BikerChallengeStatus;

import java.sql.Timestamp;
import java.util.UUID;

public record BikerChallengeDto(Long id,
                                Long bikerId,
                                UUID challenge,
                                Long creditNumber,
                                BikerChallengeStatus bikerChallengeStatus,
                                Timestamp creationDate) {
}
