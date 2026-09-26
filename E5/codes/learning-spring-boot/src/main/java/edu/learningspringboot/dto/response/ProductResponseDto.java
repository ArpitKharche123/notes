package edu.learningspringboot.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDto {
    private Long id;

    private String name;

    private String category;

    private BigDecimal price;
}
