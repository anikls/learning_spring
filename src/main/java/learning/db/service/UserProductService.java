package learning.db.service;

import learning.db.dto.ProductDto;

import java.util.List;

/**
 * @author NAgafonov
 */
public interface UserProductService {

    List<ProductDto> getUserProducts(Long userId);

    ProductDto getProduct(Long productId);
}
