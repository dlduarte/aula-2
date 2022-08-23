package br.com.dld.aula1.repositories;

import br.com.dld.aula1.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}