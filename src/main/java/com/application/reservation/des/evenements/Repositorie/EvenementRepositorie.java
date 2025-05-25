package com.application.reservation.des.evenements.Repositorie;

import com.application.reservation.des.evenements.Entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.transform.Result;
import java.util.List;

public interface EvenementRepositorie extends JpaRepository<Evenement,Long> {

    @Query(value = "select", nativeQuery = true)
    List<Result> findBy(Long id);

}
