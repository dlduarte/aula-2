package br.com.dld.aula2.models.forms;

import br.com.dld.aula2.models.entities.Product;
import br.com.dld.aula2.models.enums.Unit;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author David Duarte
 * @created 23/08/2022
 * @project aula-2
 */
@Data
public class ProductForm {

    private String description;
    private Unit unit;
    private BigDecimal price;

    public Product convert() {
        Product product = new Product();
        product.setDescription(description);
        product.setPrice(price);
        product.setUnit(unit);

        return product;
    }
}
