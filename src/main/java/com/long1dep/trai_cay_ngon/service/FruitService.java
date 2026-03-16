package com.long1dep.trai_cay_ngon.service;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import com.long1dep.trai_cay_ngon.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FruitService {
    private final FruitRepository fruitRepo;

    public List<Fruits> getAll() {
        return fruitRepo.findAll();
    }
    public Page<Fruits> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fruitRepo.findAll(pageable);
    }
    public Fruits getOne(Long id) {
        return fruitRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found the given id of fruits"));
    }
    public Fruits save(Fruits obj) {
        return fruitRepo.save(obj);
    }
    public Fruits updateById(Long id, Fruits obj) {
        if (!fruitRepo.existsById(id)) {
            throw new RuntimeException("Not found the given id of fruits");
        }
        obj.setId(id);
        return fruitRepo.save(obj);
    }
    public void deleteById(Long id) {
        if (!fruitRepo.existsById(id)) {
            throw new RuntimeException("Not found the given id of fruits");
        }
        fruitRepo.deleteById(id);
    }
}
