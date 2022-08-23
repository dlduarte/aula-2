package br.com.dld.aula2.repositories;

import br.com.dld.aula2.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}