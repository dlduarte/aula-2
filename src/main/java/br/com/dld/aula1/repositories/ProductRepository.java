package br.com.dld.aula1.repositories;

import br.com.dld.aula1.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByDescriptionContains(String description);
}