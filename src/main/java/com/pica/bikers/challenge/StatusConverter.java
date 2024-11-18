package com.pica.bikers.challenge;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<BikerChallengeStatus, String> {

    @Override
    public String convertToDatabaseColumn(BikerChallengeStatus bikerChallengeStatus) {
        return Arrays.stream(BikerChallengeStatus.values())
                .filter(s -> s == bikerChallengeStatus)
                .map(BikerChallengeStatus::getCode)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No biker challenge found"));
    }

    @Override
    public BikerChallengeStatus convertToEntityAttribute(String code) {
        return Arrays.stream(BikerChallengeStatus.values())
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No biker challenge code found"));
    }
}