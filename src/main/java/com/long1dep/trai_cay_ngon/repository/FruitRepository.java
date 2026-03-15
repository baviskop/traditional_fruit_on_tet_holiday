package com.long1dep.trai_cay_ngon.repository;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruits, Long> {
}
