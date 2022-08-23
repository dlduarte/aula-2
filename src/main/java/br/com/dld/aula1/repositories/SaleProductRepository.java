package br.com.dld.aula1.repositories;

import br.com.dld.aula1.models.entities.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {

    List<SaleProduct> findAllBySale_Id(long saleId);

    void deleteAllBySale_Id(long saleId);
}