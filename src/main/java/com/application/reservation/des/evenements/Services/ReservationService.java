package com.application.reservation.des.evenements.Services;

import com.application.reservation.des.evenements.Controllers.ReservationController;
import com.application.reservation.des.evenements.DTO.ReservationDto;
import com.application.reservation.des.evenements.Entity.Evenement;
import com.application.reservation.des.evenements.Entity.Reservation;
import com.application.reservation.des.evenements.Mapper.ReservationMapper;
import com.application.reservation.des.evenements.Repositorie.ClientRepositorie;
import com.application.reservation.des.evenements.Repositorie.EvenementRepositorie;
import com.application.reservation.des.evenements.Repositorie.ReservationRepositorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service

public class ReservationService {


    private final ReservationRepositorie reservationRepository;
    private final ClientRepositorie clientRepository;
    private final EvenementRepositorie eventRepository;
    private ReservationMapper reservationMapper;

    @Transactional
    public ReservationDto Resrever(ReservationDto reservatioDto){
        var client = clientRepository.findById(reservatioDto.getClientid()).orElse(null);
        var event = eventRepository.findById(reservatioDto.getEventId()).orElse(null);

        var res = reservationRepository.save(new Reservation(null,client,event));
        return new ReservationDto(res.getIdreservation(), res.getClient().getId(), res.getEvenement().getIdEvent());
    }

    public List<ReservationDto>  getAllReservation(){
        return reservationRepository.findAll().stream()
                .map(res->reservationMapper.reservationToDto(res))
                .toList();
    }

    public ReservationDto getReservationById(Long id){
        return reservationRepository.findById(id)
                .map(ress->reservationMapper.reservationToDto(ress))
                .orElseThrow(()->new RuntimeException("Reservation Not Found"));
    }

    public ReservationService(ReservationMapper reservationMapper, EvenementRepositorie eventRepository, ClientRepositorie clientRepository, ReservationRepositorie reservationRepository) {
        this.reservationMapper = reservationMapper;
        this.eventRepository = eventRepository;
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
    }


}
