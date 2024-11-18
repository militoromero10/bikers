package com.pica.bikers.bicker;

import java.sql.Timestamp;

public record BikerDto(Long id, Long piun, String name, Timestamp birthdate) {
}
