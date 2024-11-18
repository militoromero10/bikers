package com.pica.bikers.challenge.external;

import java.util.UUID;

public record ChallengeDto(Long id, String name, UUID externalId, ChallengeLevel challengeLevel, String description){}
