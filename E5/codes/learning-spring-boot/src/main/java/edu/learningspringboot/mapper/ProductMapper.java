package edu.learningspringboot.mapper;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.response.ProductResponseDto;
import edu.learningspringboot.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper mapper;

    public Product toEntity(ProductRequestDto productRequestDto) {
        return mapper.map(productRequestDto, Product.class);
    }

    public ProductResponseDto toDto(Product product) {
        return mapper.map(product, ProductResponseDto.class);
    }

    public void updateProduct(ProductRequestDto productRequestDto,
                              Product product) {

        mapper.map(productRequestDto, product);
    }



}
