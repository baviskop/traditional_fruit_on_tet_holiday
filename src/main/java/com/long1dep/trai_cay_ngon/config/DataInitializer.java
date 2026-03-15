package com.long1dep.trai_cay_ngon.config;

import com.long1dep.trai_cay_ngon.entity.Fruits;
import com.long1dep.trai_cay_ngon.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FruitRepository fruitRepo;

    @Override
    public void run(String... args) throws Exception {
        List<Fruits> fruits = List.of(
                Fruits.builder()
                        .name("Mãn Cầu")
                        .description("Man cau tuoi ngon moi ban")
                        .price(30000)
                        .build(),
                Fruits.builder()
                        .name("Dừa")
                        .description("Dua mong nuoc")
                        .price(40000)
                        .build(),
                Fruits.builder()
                        .name("Sung")
                        .description("Sung tuoi ngon moi ban")
                        .price(50000)
                        .build(),
                Fruits.builder()
                        .name("Đu đủ")
                        .description("Du du tuoi ngon moi ban")
                        .price(60000)
                        .build(),
                Fruits.builder()
                        .name("Xoài")
                        .description("Xoai tuoi ngon moi ban")
                        .price(70000)
                        .build()
        );

        fruitRepo.saveAll(fruits);
    }
}
