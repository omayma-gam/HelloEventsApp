package com.application.reservation.des.evenements.Entity;

import jakarta.persistence.*;

@Entity

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idreservation;
    @ManyToOne
    private Client client;

    @ManyToOne
    private Evenement evenement;

    public Long getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Long idreservation) {
        this.idreservation = idreservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Reservation(Long idreservation, Client client, Evenement evenement) {
        this.idreservation = idreservation;
        this.client = client;
        this.evenement = evenement;
    }

    public Reservation() {
    }
}