package com.pica.bikers.bicker;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bikers")
public class BikerController {

    private final BikerService bikerService;

    @PostMapping
    public ResponseEntity<BikerResponseDto> createBiker(@RequestBody BikerDto bikerDto){
        return new ResponseEntity<>(bikerService.createBiker(bikerDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BikerDto>> listAll(){
        return new ResponseEntity<>(bikerService.listAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}/challenges")
    public ResponseEntity<List<BikerChallengeDto>> challengesByBiker(@PathVariable Long id){
        return new ResponseEntity<>(bikerService.challengesByBiker(id), HttpStatus.OK);
    }
}
