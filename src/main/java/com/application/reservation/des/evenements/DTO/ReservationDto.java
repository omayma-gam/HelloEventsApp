package com.application.reservation.des.evenements.DTO;


public class ReservationDto {

    private Long idReservation;
    private Long clientid;
    private Long eventId;

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public ReservationDto(Long idReservation, Long clientid, Long eventId) {
        this.idReservation = idReservation;
        this.clientid = clientid;
        this.eventId = eventId;
    }

    public ReservationDto() {
    }
}