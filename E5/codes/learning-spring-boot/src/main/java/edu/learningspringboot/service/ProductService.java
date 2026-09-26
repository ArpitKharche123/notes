package edu.learningspringboot.service;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.request.UpdateProductPrice;
import edu.learningspringboot.dto.response.PageResponse;
import edu.learningspringboot.dto.response.ProductResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    //Business Logic Plan

    public ProductResponseDto findProductById(Long id);

    public List<ProductResponseDto> findAllProducts();

   ProductResponseDto findByNameAndCategory(String name,String category);

   List<ProductResponseDto> searchProducts(String keyword);

   ProductResponseDto getLatestProduct();

   PageResponse<ProductResponseDto> getProducts(Pageable pageable);

    public ProductResponseDto addProduct(
            ProductRequestDto productRequestDto);

    public ProductResponseDto updateProduct(
            Long id,
            ProductRequestDto productRequestDto);

    public ProductResponseDto updateProductPrice(
            Long id,
            UpdateProductPrice updateProductPrice);

    public void deleteProductById(Long id);
}
