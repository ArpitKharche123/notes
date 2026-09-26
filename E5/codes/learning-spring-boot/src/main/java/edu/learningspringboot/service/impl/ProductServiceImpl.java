package edu.learningspringboot.service.impl;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.request.UpdateProductPrice;
import edu.learningspringboot.dto.response.PageResponse;
import edu.learningspringboot.dto.response.ProductResponseDto;
import edu.learningspringboot.entity.Product;
import edu.learningspringboot.exception.NotFoundException;
import edu.learningspringboot.mapper.ProductMapper;
import edu.learningspringboot.repository.ProductRepository;
import edu.learningspringboot.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
   private ProductRepository productRepository;
   private ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper,
                              ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto findProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "Product not found for the given id")
                );

        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDto> findAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto findByNameAndCategory(String name, String category) {

        Product product
        = productRepository.findByNameAndCategory(name, category).
        orElseThrow(
                () ->
            new RuntimeException(
       "Product not found for the given name and category")
        );

        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDto> searchProducts(String keyword) {
        return productRepository.searchProduct(keyword)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto getLatestProduct() {
        Product product
                = productRepository.getLatestProduct()
                .orElseThrow(
                        () -> new RuntimeException("Product not found")
                );
        return productMapper.toDto(product);
    }

    @Override
    public PageResponse<ProductResponseDto> getProducts(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        return PageResponse.of(
             page.map(productMapper::toDto)
        );
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {

        Product product = productMapper.toEntity(productRequestDto);

        Product saved = productRepository.save(product);

        return productMapper.toDto(saved);
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(Long id,
                    ProductRequestDto productRequestDto) {

        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Product not found for the given id")
                );

        productMapper.updateProduct(productRequestDto, product);
//        existingProduct.setName(productRequestDto.getName());
//        existingProduct.setPrice(productRequestDto.getPrice());
//        existingProduct.setCategory(productRequestDto.getCategory());

//        Product savedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public ProductResponseDto updateProductPrice(
            Long id, UpdateProductPrice updateProductPrice) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Product not found for the given id")
                );
        product.setPrice(updateProductPrice.getPrice());

//        Product savedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
