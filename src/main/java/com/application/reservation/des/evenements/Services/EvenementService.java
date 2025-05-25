package com.application.reservation.des.evenements.Services;

import com.application.reservation.des.evenements.DTO.EvenementDto;
import com.application.reservation.des.evenements.Entity.Evenement;
import com.application.reservation.des.evenements.Mapper.EventMapper;
import com.application.reservation.des.evenements.Repositorie.EvenementRepositorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service

public class EvenementService {

    private final EvenementRepositorie eventRepository;
    private EventMapper eventMapper;


    @Transactional
    public EvenementDto AddEvent(EvenementDto eventDto) {
        return eventMapper.eventToDto(eventRepository.save(eventMapper.dtoToEvent(eventDto)));
    }

    public List<EvenementDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event ->eventMapper.eventToDto(event))
                .toList();
    }

    public EvenementDto getEventById(Long id){
        return eventRepository.findById(id)
                .map(evenement -> eventMapper.eventToDto(evenement))
                .orElseThrow(()->new RuntimeException("event not found"));
    }

    public EvenementDto updateEvent(Long id , EvenementDto eventDto) {
        Evenement ev = eventRepository.findById(id).get();
        ev.setEventname(eventDto.getEventname());
        ev.setType(eventDto.getType());
        ev.setDescription(eventDto.getDescription());

        return eventMapper.eventToDto(eventRepository.save(eventMapper.dtoToEvent(eventDto)));

    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }

    public EvenementService(EventMapper eventMapper, EvenementRepositorie eventRepository) {
        this.eventMapper = eventMapper;
        this.eventRepository = eventRepository;
    }
}
