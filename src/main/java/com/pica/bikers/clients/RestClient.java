package com.pica.bikers.clients;

import com.pica.bikers.challenge.external.ChallengeDto;
import com.pica.bikers.challenge.external.ChallengeLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestClient {

    @Value("${HOST}")
    String host;
    @Value("${PORT}")
    String port;
    private final RestTemplate restTemplate;

    public List<ChallengeDto> fetchAllByChallengeLevel(ChallengeLevel level) {
        String url = String.format("%s:%s/api/challenges/level/{cl}", host, port);
        return restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ChallengeDto>>() {},
                level.getCode()
        ).getBody();
    }
}