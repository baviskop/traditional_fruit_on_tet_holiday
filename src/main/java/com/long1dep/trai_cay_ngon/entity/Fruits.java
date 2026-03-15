package com.long1dep.trai_cay_ngon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "fruits")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Fruits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "nvarchar(30)")
    @NotBlank(message = "The fruit name is required!")
    @Size(min = 2, max = 30, message = "The fruit name must be in 2..30 characters length!")
    private String name;

    @Column(nullable = false, columnDefinition = "nvarchar(100)")
    @NotBlank(message = "The fruit name is required!")
    @Size(min = 5, max = 100, message = "The fruit name must be in 5..100 characters length!")
    private String description;

    @Positive(message = "The fruit price must be > 0!")
    @Min(value = 5000, message = "The minimum price is 5.000đ!")
    @Max(value = 5000000, message = "The maximum price is 5.000.000đ!")
    private double price;

    //nhập thông qua dropdown bên FE
    @Column(columnDefinition = "nvarchar(30)")
    @Pattern(regexp = "(Trái cây tươi|Chế biến sẵn|Trái cây sấy/lon)", message = "The type must be in type of Trái cây tươi, Chế biến sẵn, Trái cây sấy/lon")
    @Builder.Default
    private String type = "Trái cây tươi";
    //tách bảng, đây là FK trỏ tới table Type/Category
    //dùng Enum
    //RegEx
}
