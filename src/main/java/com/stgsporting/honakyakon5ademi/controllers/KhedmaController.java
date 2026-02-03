package com.stgsporting.honakyakon5ademi.controllers;

import com.stgsporting.honakyakon5ademi.services.KhedmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/khedmas")
public class KhedmaController {
    private final KhedmaService khedmaService;

    public KhedmaController(KhedmaService khedmaService) {
        this.khedmaService = khedmaService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(khedmaService.getAllKhedmaNames());
    }
}
