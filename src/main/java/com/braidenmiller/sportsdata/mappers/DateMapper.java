package com.braidenmiller.sportsdata.mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateMapper {
    public Date toDate(LocalDateTime date) {
        return Date.from(date.toInstant(ZoneOffset.UTC));
    }

    public LocalDateTime ToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
    }
}
