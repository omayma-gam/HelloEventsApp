package com.application.reservation.des.evenements.Repositorie;

import com.application.reservation.des.evenements.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepositorie extends JpaRepository<Reservation,Long> {
}
