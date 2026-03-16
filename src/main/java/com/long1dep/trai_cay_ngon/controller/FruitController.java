package com.long1dep.trai_cay_ngon.controller;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import com.long1dep.trai_cay_ngon.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fruits")
public class FruitController {
    private final FruitService fruitService;

    @GetMapping()
    public ResponseEntity<List<Fruits>> getAllFruits() {
        return ResponseEntity.ok(fruitService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fruits> getFruitById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(fruitService.getOne(id));
    }
    @PostMapping("/save")
    public ResponseEntity<Fruits> saveFruit(@RequestBody Fruits fruits) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.save(fruits));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Fruits> updateFruit(@PathVariable("id") Long id, @RequestBody Fruits fruits) {
        return ResponseEntity.ok(fruitService.updateById(id, fruits));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable("id") Long id) {
        fruitService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
