package com.long1dep.trai_cay_ngon.controller;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import com.long1dep.trai_cay_ngon.service.impl.FruitServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fruits")
public class FruitController {
    private final FruitServiceImpl fruitService;
    @GetMapping
    public ResponseEntity<List<Fruits>> getAllFruits() {
        return ResponseEntity.ok(fruitService.getAllFruits());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Fruits>> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        return ResponseEntity.ok(fruitService.getPage(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruits> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(fruitService.getOne(id));
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getTypes() {
        return ResponseEntity.ok(fruitService.getTypes());
    }

    @PostMapping
    public ResponseEntity<Fruits> save(@Valid @RequestBody Fruits obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.save(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        fruitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fruits> updateById(@PathVariable("id") Long id, @Valid @RequestBody Fruits obj) {
        return ResponseEntity.ok(fruitService.updateById(id, obj));
    }

}
