package edu.learningspringboot.controller;

import edu.learningspringboot.dto.request.ProductRequestDto;
import edu.learningspringboot.dto.request.UpdateProductPrice;
import edu.learningspringboot.dto.response.ApiResponseDto;
import edu.learningspringboot.dto.response.ProductResponseDto;
import edu.learningspringboot.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//http://localhost:8080/api/v1/products
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //handler methods

    //http://localhost:8080/api/v1/products/1
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ProductResponseDto>> findProductById(
            @PathVariable Long id,
            HttpServletRequest request
    ) {
        return ResponseEntity.ok(
                ApiResponseDto.success(
                        "Product fetched successfully",
                        HttpStatus.OK.value(),
                        productService.findProductById(id),
                        request.getRequestURI()
                )
        );
    }

    @GetMapping
    //http://localhost:8080/api/v1/products
    public ApiResponseDto<?> findAllProducts(
            HttpServletRequest request
    ) {
        return ApiResponseDto.success(
                "Products fetched successfully",
                200,
                productService.findAllProducts(),
                request.getRequestURI()
        );
    }

    @GetMapping("/name-and-category")
    ProductResponseDto findByNameAndCategory(
            @RequestParam
            @NotBlank(message = "name is required")
            String name,
            @RequestParam
            @NotBlank(message = "category is required")
            String category) {
        return productService.findByNameAndCategory(name, category);
    }

    @GetMapping("/search")
    List<ProductResponseDto> searchProduct(
            @RequestParam
            String keyword) {
        return productService.searchProducts(keyword);
    }

    @GetMapping("/latest")
    ProductResponseDto getLatestProduct() {
        return productService.getLatestProduct();
    }

    @GetMapping("/list")
    ResponseEntity<?> getProducts(
            @ParameterObject
            @PageableDefault(
                    size = 2,
                    page = 0,
                    sort = "name",
                    direction = Sort.Direction.ASC
            )
            Pageable pageable
    ){
        return ResponseEntity.ok(
                productService.getProducts(pageable)
        );
    }

    @PostMapping
    public ResponseEntity<?> addProduct(
            @RequestBody
            @Valid
            ProductRequestDto productRequestDto,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(
                        ApiResponseDto.success(
                        "Product added successfully",
                        HttpStatus.CREATED.value(),
                        productService.addProduct(productRequestDto),
                        request.getRequestURI()
                ));
    }

    @PutMapping("/{id}")
    ProductResponseDto updateProduct(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    @PatchMapping("/{id}")
    public ProductResponseDto updateProductPrice(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            UpdateProductPrice updateProductPrice) {
        return productService.updateProductPrice(
                id, updateProductPrice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(
            @PathVariable
            Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
