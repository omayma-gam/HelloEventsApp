package com.application.reservation.des.evenements.Controllers;

import com.application.reservation.des.evenements.DTO.EvenementDto;
import com.application.reservation.des.evenements.Entity.Evenement;
import com.application.reservation.des.evenements.Services.EvenementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class EvenementController {

    public EvenementService eventService;

    @PostMapping("/addEvent")
    public EvenementDto addEvent(@RequestBody EvenementDto eventDto) {
        return eventService.AddEvent(eventDto);
    }
    @GetMapping("/allEvents")
    public List<EvenementDto> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("/event/{id}")
    public EvenementDto getEventById(@PathVariable Long id ) {
        return  eventService.getEventById(id);
    }
    @PutMapping("/event/{id}")
    public EvenementDto updatEvent(@PathVariable Long id ,@RequestBody EvenementDto eventDto) {
        return eventService.updateEvent(id,eventDto);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable Long id ) {
        eventService.deleteEvent(id);
    }




}
