package com.application.reservation.des.evenements.Mapper;

import com.application.reservation.des.evenements.DTO.EvenementDto;
import com.application.reservation.des.evenements.Entity.Evenement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" ,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    EvenementDto eventToDto(Evenement    evenement);
    Evenement dtoToEvent(EvenementDto eventDto);
}
