package br.com.dld.aula2.models.dtos;

import br.com.dld.aula2.models.entities.Customer;
import br.com.dld.aula2.models.entities.Product;
import br.com.dld.aula2.models.entities.Sale;
import br.com.dld.aula2.models.entities.SaleProduct;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author David Duarte
 * @created 23/08/2022
 * @project aula-2
 */
@Data
public class SaleDto {

    private long id;
    private Customer customer;
    private String seller;
    private BigDecimal total;
    private List<SaleProductDto> products;

    public SaleDto() {
        this.products = new ArrayList<>();
    }

    @Data
    public static class SaleProductDto {

        private long id;

        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        private Product product;
        private int amount;
        private BigDecimal subTotal;
    }

    public static SaleDto create(Sale sale, List<SaleProduct> products) {
        SaleDto dto = new SaleDto();
        dto.setId(sale.getId());
        dto.setCustomer(sale.getCustomer());
        dto.setSeller(sale.getSeller());
        dto.setTotal(sale.getTotal());

        dto.setProducts(products
                .stream()
                .map(sp -> {
                    SaleProductDto spd = new SaleProductDto();
                    spd.setId(sp.getId());
                    spd.setProduct(sp.getProduct());
                    spd.setAmount(sp.getAmount());
                    spd.setSubTotal(sp.getSubTotal());

                    return spd;
                })
                .collect(Collectors.toList())
        );

        return dto;
    }
}
