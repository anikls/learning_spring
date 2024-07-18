package learning.db.dto;

import java.util.List;

/**
 * @author NAgafonov
 */
public class UserProductsResponseDto {

    private List<ProductDto> products;

    public UserProductsResponseDto(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
