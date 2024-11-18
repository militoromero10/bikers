package com.pica.bikers.bicker;

import com.pica.bikers.challenge.BikerChallenge;
import com.pica.bikers.challenge.BikerChallengeRepository;
import com.pica.bikers.challenge.BikerChallengeStatus;
import com.pica.bikers.challenge.external.ChallengeDto;
import com.pica.bikers.challenge.external.ChallengeLevel;
import com.pica.bikers.clients.RestClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BikerService {

    private final BikerRepository bikerRepository;
    private final BikerChallengeRepository bikerChallengeRepository;
    private final RestClient restClient;

    public BikerResponseDto createBiker(BikerDto bikerDto){

        List<ChallengeDto> challenges = restClient.fetchAllByChallengeLevel(ChallengeLevel.MEDIUM);
        Biker biker = buildAndPersistBiker(bikerDto);
        log.info("Biker created: {}", biker);
        buildAndPersistBikerChallenges(biker, challenges);
        return new BikerResponseDto("Challenges currently processed", 200);

    }

    public List<BikerDto> listAll(){
        return bikerRepository.findAll()
                .stream()
                .map( biker -> new BikerDto(biker.getId(), biker.getId(), biker.getName(),biker.getBirthdate()))
                .toList();
    }

    public List<BikerChallengeDto> challengesByBiker(Long id){
        return bikerChallengeRepository.findAllByBikerId(id)
                .stream()
                .map( bikerChallenge -> new BikerChallengeDto(
                        bikerChallenge.getId(),
                        bikerChallenge.getBikerId(),
                        bikerChallenge.getChallengeId(),
                        bikerChallenge.getCreditNumber(),
                        bikerChallenge.getBikerChallengeStatus(),
                        bikerChallenge.getCreationDate()))
                .toList();
    }

    private void buildAndPersistBikerChallenges(Biker biker, List<ChallengeDto> challenges) {
        List<BikerChallenge> bikerChallenges = new ArrayList<>();

        for(ChallengeDto challengeDto: challenges){
            BikerChallenge bikerChallenge = new BikerChallenge();
            bikerChallenge.setChallengeId(challengeDto.externalId());
            bikerChallenge.setBikerId(biker.getId());
            bikerChallenge.setBikerChallengeStatus(BikerChallengeStatus.NOT_COMPLETED);
            bikerChallenge.setCreationDate(new Timestamp(System.currentTimeMillis()));
            bikerChallenge.setCreditNumber(70L);
            bikerChallenges.add(bikerChallenge);

        }
        bikerChallengeRepository.saveAll(bikerChallenges);
        log.info("Biker challenges persisted: {}", bikerChallenges);

    }

    private Biker buildAndPersistBiker(BikerDto bikerDto) {
        Biker biker = new Biker();
        biker.setBirthdate(bikerDto.birthdate());
        biker.setName(bikerDto.name());
        biker.setPiun(bikerDto.piun());
        return bikerRepository.save(biker);
    }
}
