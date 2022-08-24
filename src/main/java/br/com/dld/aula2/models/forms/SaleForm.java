package br.com.dld.aula2.models.forms;

import br.com.dld.aula2.models.entities.Customer;
import br.com.dld.aula2.models.entities.Product;
import br.com.dld.aula2.models.entities.Sale;
import br.com.dld.aula2.models.entities.SaleProduct;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author David Duarte
 * @created 23/08/2022
 * @project aula-2
 */
@Data
public class SaleForm {

    private long id;
    private long customerId;
    private String seller;
    private BigDecimal total;
    private List<SaleProductForm> products;

    @Data
    public static class SaleProductForm {

        private long id;
        private long productId;
        private int amount;
        private BigDecimal subTotal;
    }

    public Sale convert() {
        Sale sale = new Sale();
        sale.setId(id);

        Customer customer = new Customer();
        customer.setId(customerId);

        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        return sale;
    }

    public List<SaleProduct> convertProducts() {
        return products
                .stream()
                .map(spf -> {
                    SaleProduct saleProduct = new SaleProduct();
                    saleProduct.setId(spf.getId());

                    Product product = new Product();
                    product.setId(spf.getProductId());

                    saleProduct.setProduct(product);
                    saleProduct.setAmount(spf.getAmount());
                    saleProduct.setSubTotal(spf.getSubTotal());

                    return saleProduct;
                })
                .collect(Collectors.toList());
    }
}
