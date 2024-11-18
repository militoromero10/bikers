package com.pica.bikers.challenge.external;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChallengeLevel {
    EASY("E"), MEDIUM("M"), HARD("H");

    private final String code;

    public static ChallengeLevel fromCode(String code) {
        for (ChallengeLevel difficulty : ChallengeLevel.values()) {
            if (difficulty.getCode().equals(code)) {
                return difficulty;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }
}
