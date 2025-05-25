package com.application.reservation.des.evenements.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity

public class Admin extends User {
    @Id
    @GeneratedValue
    private Long id;

    public Admin() {
        this.setRole(Role.ADMIN);
    }

    @OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL)
    private List<Evenement> evenements;

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}