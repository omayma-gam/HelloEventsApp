package com.application.reservation.des.evenements.Repositorie;

import com.application.reservation.des.evenements.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositorie extends JpaRepository<Client,Long> {
}
