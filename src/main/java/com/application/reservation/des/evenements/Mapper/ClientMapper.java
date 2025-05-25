package com.application.reservation.des.evenements.Mapper;

import com.application.reservation.des.evenements.DTO.ClientDto;
import com.application.reservation.des.evenements.Entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    ClientDto toClientDto(Client     client);
    Client toCliententity(ClientDto clientDto);

}
