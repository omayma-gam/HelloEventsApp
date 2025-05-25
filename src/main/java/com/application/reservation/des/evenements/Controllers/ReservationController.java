package com.application.reservation.des.evenements.Controllers;

import com.application.reservation.des.evenements.DTO.ReservationDto;
import com.application.reservation.des.evenements.Entity.Reservation;
import com.application.reservation.des.evenements.Services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {

    public ReservationService resrvationService;

    @PostMapping("/addReservation")
    public ReservationDto addReservation(@RequestBody  ReservationDto reservatioDto){
        return resrvationService.Resrever(reservatioDto);
    }

    @GetMapping("/allReservations")
    public List<ReservationDto> getAllReservations(){
        return resrvationService.getAllReservation();
    }

    @GetMapping("/reservation/{id}")
    public ReservationDto getreservationById(@PathVariable  Long id ){
        return resrvationService.getReservationById(id);
    }
}
