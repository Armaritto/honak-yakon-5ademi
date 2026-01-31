package com.stgsporting.honakyakon5ademi.services;

import com.stgsporting.honakyakon5ademi.entities.Khedma;
import com.stgsporting.honakyakon5ademi.exceptions.KhedmaNotFound;
import com.stgsporting.honakyakon5ademi.repositories.KhedmaRepository;
import org.springframework.stereotype.Service;

@Service
public class KhedmaService {
    private final KhedmaRepository khedmaRepository;

    public KhedmaService(KhedmaRepository khedmaRepository) {
        this.khedmaRepository = khedmaRepository;
    }

    public Khedma getKhedmaByName(String name) {
        return khedmaRepository
                .findByName(name)
                .orElseThrow(
                        () -> new KhedmaNotFound("Khedma not found")
                );
    }
}
