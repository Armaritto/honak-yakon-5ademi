package com.stgsporting.honakyakon5ademi.repositories;

import com.stgsporting.honakyakon5ademi.entities.Khedma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KhedmaRepository extends JpaRepository<Khedma, Long> {
    Optional<Khedma> findByName(String name);
}
