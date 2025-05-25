package com.application.reservation.des.evenements.Mapper;


import com.application.reservation.des.evenements.DTO.ReservationDto;
import com.application.reservation.des.evenements.Entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    //@Mapping(source = "idreservation", target = "idReservation")
    ReservationDto reservationToDto(Reservation reservation);
    Reservation DtoToReservation(ReservationDto dto);

}
