package com.pica.bikers.bicker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
interface BikerRepository extends JpaRepository<Biker, Long> {

    Optional<Biker> getBikerByPiun(Integer piun);
    List<Biker> getBikerByBirthdate(Timestamp date);
}
