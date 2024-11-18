package com.pica.bikers.bicker;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "biker", indexes = @Index(name = "biker_name_Idx", columnList = "name"))
public class Biker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long piun;
    private String name;
    private Timestamp birthdate;

}
