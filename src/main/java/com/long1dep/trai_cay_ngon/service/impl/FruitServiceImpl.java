package com.long1dep.trai_cay_ngon.service.impl;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import com.long1dep.trai_cay_ngon.repository.FruitRepository;
import com.long1dep.trai_cay_ngon.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Fruits> getAllFruits() {
        return fruitRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Fruits> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fruitRepo.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Fruits getOne(Long id) {
        return fruitRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Not found your given id"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getTypes() {
        List<String> types = List.of(
                "Trái cây tươi",
                "Chế biến sẵn",
                "Trái cây sấy/lon");
        return types;
    }

    @Override
    @Transactional
    public Fruits save(Fruits obj) {
        if (fruitRepo.existsFruitsByName(obj.getName())) {
            throw new DataIntegrityViolationException("Fruits with the same name already exists");
        }
        return fruitRepo.save(obj);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!fruitRepo.existsById(id)) {
            throw new NoSuchElementException("Not found your given id");
        }
        fruitRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Fruits updateById(Long id, Fruits obj) {
        if (!fruitRepo.existsById(id)) {
            throw new NoSuchElementException("Not found your given id");
        }
        obj.setId(id);
        return fruitRepo.save(obj);
    }
}
