package br.com.dld.aula2.models.entities;

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
@Entity(name = "sale_products")
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private BigDecimal subTotal;
}
