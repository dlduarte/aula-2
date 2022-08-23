package br.com.dld.aula1.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author David Duarte
 * @created 23/08/2022
 * @project aula-2
 */
@Getter
@Setter
@Entity(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(length = 100)
    private String seller;

    @Column(nullable = false)
    private BigDecimal total;
}
