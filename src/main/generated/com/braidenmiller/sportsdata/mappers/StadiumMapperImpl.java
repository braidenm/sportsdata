package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.StadiumEntity;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-05T22:24:49-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
public class StadiumMapperImpl implements StadiumMapper {

    @Override
    public StadiumEntity toEntity(StadiumDTO stadiumDTO) {
        if ( stadiumDTO == null ) {
            return null;
        }

        StadiumEntity stadiumEntity = new StadiumEntity();

        stadiumEntity.setStadiumID( stadiumDTO.getStadiumID() );
        stadiumEntity.setActive( stadiumDTO.isActive() );
        stadiumEntity.setName( stadiumDTO.getName() );
        stadiumEntity.setDome( stadiumDTO.isDome() );
        stadiumEntity.setCity( stadiumDTO.getCity() );
        stadiumEntity.setState( stadiumDTO.getState() );
        stadiumEntity.setGeoLat( stadiumDTO.getGeoLat() );
        stadiumEntity.setGeoLong( stadiumDTO.getGeoLong() );

        return stadiumEntity;
    }

    @Override
    public StadiumDTO fromEntity(StadiumEntity stadiumEntity) {
        if ( stadiumEntity == null ) {
            return null;
        }

        StadiumDTO stadiumDTO = new StadiumDTO();

        stadiumDTO.setStadiumID( stadiumEntity.getStadiumID() );
        stadiumDTO.setActive( stadiumEntity.isActive() );
        stadiumDTO.setName( stadiumEntity.getName() );
        stadiumDTO.setDome( stadiumEntity.isDome() );
        stadiumDTO.setCity( stadiumEntity.getCity() );
        stadiumDTO.setState( stadiumEntity.getState() );
        stadiumDTO.setGeoLat( stadiumEntity.getGeoLat() );
        stadiumDTO.setGeoLong( stadiumEntity.getGeoLong() );

        return stadiumDTO;
    }
}
