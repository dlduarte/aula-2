package br.com.dld.aula2.controllers;


import br.com.dld.aula2.models.dtos.SaleDto;
import br.com.dld.aula2.models.forms.SaleForm;
import br.com.dld.aula2.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable long id) {
        Optional<SaleDto> productOpt = saleService.findById(id);

        if (productOpt.isPresent()) {
            return ResponseEntity.ok(productOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    private ResponseEntity<?> findAll() {
        return ResponseEntity.ok(saleService.findAll());
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody SaleForm form) {
        SaleDto sale = saleService.save(form);

        return ResponseEntity.ok(sale);
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody SaleForm form) {
        SaleDto sale = saleService.update(form);

        return ResponseEntity.ok(sale);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> remove(@PathVariable long id) {
        saleService.delete(id);

        return ResponseEntity.ok().build();
    }
}
