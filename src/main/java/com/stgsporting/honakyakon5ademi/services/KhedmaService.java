package com.stgsporting.honakyakon5ademi.services;

import com.stgsporting.honakyakon5ademi.dtos.ProgressDTO;
import com.stgsporting.honakyakon5ademi.entities.Khedma;
import com.stgsporting.honakyakon5ademi.exceptions.KhedmaNotFound;
import com.stgsporting.honakyakon5ademi.repositories.KhedmaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ProgressDTO> getTodayProgress() {
        List<ProgressDTO> progressDTOS = new ArrayList<>();
        List<Khedma> khedmas = khedmaRepository.findAll();
        for (Khedma k : khedmas) {
            ProgressDTO progressDTO = new ProgressDTO();
            progressDTO.setProgress(k.getTodayProgress());
            progressDTO.setName(k.getName());
            progressDTOS.add(progressDTO);
        }
        return progressDTOS;
    }

    public List<ProgressDTO> getTotalProgress() {
        List<ProgressDTO> progressDTOS = new ArrayList<>();
        List<Khedma> khedmas = khedmaRepository.findAll();
        for (Khedma k : khedmas) {
            ProgressDTO progressDTO = new ProgressDTO();
            progressDTO.setProgress(k.getTotalProgress());
            progressDTO.setName(k.getName());
            progressDTOS.add(progressDTO);
        }
        return progressDTOS;
    }
}
