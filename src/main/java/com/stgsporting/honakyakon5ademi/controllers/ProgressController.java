package com.stgsporting.honakyakon5ademi.controllers;

import com.stgsporting.honakyakon5ademi.services.KhedmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/progress")
public class ProgressController {
    private final KhedmaService khedmaService;

    public ProgressController(KhedmaService khedmaService) {
        this.khedmaService = khedmaService;
    }

    @GetMapping("/total")
    public ResponseEntity<Object> getTotalProgress(){
        return ResponseEntity.ok(khedmaService.getTotalProgress());
    }

    @GetMapping("/today")
    public ResponseEntity<Object> getTodayProgress(){
        return ResponseEntity.ok(khedmaService.getTodayProgress());
    }
}
