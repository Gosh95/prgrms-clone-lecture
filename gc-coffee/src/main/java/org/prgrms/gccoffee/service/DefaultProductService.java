package org.prgrms.gccoffee.service;

import org.prgrms.gccoffee.model.Category;
import org.prgrms.gccoffee.model.Product;
import org.prgrms.gccoffee.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String productName, Category category, long price) {
        var product = new Product(randomUUID(), productName, category, price);

        return productRepository.insert(product);
    }

    @Override
    public Product createProduct(String productName, Category category, long price, String description) {
        var product = new Product(randomUUID(), productName, category, price, description, now(), now());

        return productRepository.insert(product);
    }
}
