package learning.db.repository;

import learning.db.entity.Product;

import java.util.List;

/**
 * @author NAgafonov
 */
public interface ProductRepository {
    void createProduct(Product product);
    Product getProduct(Long id);
    List<Product> getAllUserProducts(Long userId);
    void deleteProduct(Long idProduct);
}
