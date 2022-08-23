package br.com.dld.aula1.services;

import br.com.dld.aula1.models.dtos.SaleDto;
import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.models.entities.Sale;
import br.com.dld.aula1.models.entities.SaleProduct;
import br.com.dld.aula1.models.forms.SaleForm;
import br.com.dld.aula1.repositories.ProductRepository;
import br.com.dld.aula1.repositories.SaleProductRepository;
import br.com.dld.aula1.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;
    private SaleProductRepository saleProductRepository;
    private ProductRepository productRepository;

    public Optional<SaleDto> findById(long id) {
        Optional<Sale> saleOpt = saleRepository.findById(id);

        if (saleOpt.isPresent()) {
            List<SaleProduct> products = saleProductRepository.findAllBySale_Id(saleOpt.get().getId());

            return Optional.of(SaleDto.create(saleOpt.get(), products));
        }

        return Optional.empty();
    }

    public List<SaleDto> findAll() {
        return saleRepository
                .findAll()
                .stream()
                .map(sale -> {
                    List<SaleProduct> products = saleProductRepository.findAllBySale_Id(sale.getId());
                    return SaleDto.create(sale, products);
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public SaleDto save(SaleForm form) {

        Sale sale = form.convert();
        sale = saleRepository.saveAndFlush(sale);

        List<SaleProduct> products = form.convertProducts();

        Sale finalSale = sale;
        products.forEach(sp -> {
            Product product = productRepository.getReferenceById(sp.getProduct().getId());
            sp.setProduct(product);
            sp.setSale(finalSale);
            saleProductRepository.save(sp);
        });

        return SaleDto.create(sale, products);
    }

    @Transactional
    public SaleDto update(SaleForm form) {
        Sale sale = form.convert();
        sale = saleRepository.saveAndFlush(sale);

        List<SaleProduct> products = saleProductRepository.findAllBySale_Id(sale.getId());
        List<SaleProduct> productsAlt = form.convertProducts();

        Sale finalSale = sale;
        productsAlt.forEach(sp -> {
            Product product = productRepository.getReferenceById(sp.getProduct().getId());
            sp.setProduct(product);
            sp.setSale(finalSale);
            saleProductRepository.save(sp);

            if (product.getId() == null || product.getId() == 0) {
                products.removeIf(p -> Objects.equals(p.getId(), product.getId()));
            }
        });

        products.forEach(p -> saleProductRepository.deleteById(p.getId()));

        return SaleDto.create(sale, productsAlt);
    }

    @Transactional
    public void delete(long id) {
        saleProductRepository.deleteAllBySale_Id(id);
        saleRepository.deleteById(id);
    }
}
