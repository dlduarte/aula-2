package br.com.dld.aula2.models.entities;

import br.com.dld.aula2.models.enums.Unit;
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
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 2, nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(nullable = false)
    private BigDecimal price;
}
