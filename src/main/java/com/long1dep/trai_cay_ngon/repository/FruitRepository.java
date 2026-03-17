package com.long1dep.trai_cay_ngon.repository;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruits, Long> {

    boolean existsFruitsByName(String name);
}
