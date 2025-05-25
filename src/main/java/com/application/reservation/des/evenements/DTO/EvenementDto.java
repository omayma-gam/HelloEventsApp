package com.application.reservation.des.evenements.DTO;

import com.application.reservation.des.evenements.Entity.Evenement;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;




public class EvenementDto {

    private Long idEvent;
    private String eventname;
    private String description;
    private String type;

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EvenementDto(Long idEvent, String eventname, String description, String type) {
        this.idEvent = idEvent;
        this.eventname = eventname;
        this.description = description;
        this.type = type;
    }

    public EvenementDto() {
    }
}