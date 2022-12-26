package com.sanhak.l2cache.controller;

import com.sanhak.l2cache.entity.Apart;
import com.sanhak.l2cache.service.ApartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApartController {

    private final ApartService apartService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Apart>> findAllData() {
        try{
            return ResponseEntity.ok().body(apartService.findAllData());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
