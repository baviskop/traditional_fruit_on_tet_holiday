package com.long1dep.trai_cay_ngon.service;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FruitService {
    public List<Fruits> getAllFruits();
    public Page<Fruits> getPage(int page, int size);
    public Fruits getOne(Long id);
    public List<String> getTypes();

    public Fruits save(Fruits obj);
    public void deleteById(Long id);
    public Fruits updateById(Long id, Fruits obj);
}
