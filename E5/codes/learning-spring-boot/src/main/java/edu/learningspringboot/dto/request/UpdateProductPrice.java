package edu.learningspringboot.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductPrice {
    @NotNull
    @DecimalMin(value = "1.0",message = "price must be positive")
    @Digits(integer = 8,fraction = 2)
    private BigDecimal price;
}
