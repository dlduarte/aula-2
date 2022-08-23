package br.com.dld.aula1.services;

import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByDescription(String name) {
        return productRepository.findAllByDescriptionContains(name);
    }

    public Product save(Product customer) {
        return productRepository.save(customer);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
