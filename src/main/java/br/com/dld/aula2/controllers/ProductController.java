package br.com.dld.aula2.controllers;


import br.com.dld.aula2.models.entities.Product;
import br.com.dld.aula2.models.forms.ProductForm;
import br.com.dld.aula2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable long id) {
        Optional<Product> productOpt = productService.findById(id);

        if (productOpt.isPresent()) {
            return ResponseEntity.ok(productOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    private ResponseEntity<?> findAllByName(@PathParam("description") Optional<String> description) {
        if (description.isPresent()) {
            return ResponseEntity.ok(productService.findAllByDescription(description.get()));
        } else {
            return ResponseEntity.ok(productService.findAll());
        }
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody ProductForm form) {
        Product product = productService.save(form.convert());

        return ResponseEntity.ok(product);
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody Product form) {
        Product product = productService.save(form);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> remove(@PathVariable long id) {
        productService.delete(id);

        return ResponseEntity.ok().build();
    }
}
