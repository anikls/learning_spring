package learning.db.service;

import learning.db.dto.ProductDto;
import learning.db.entity.Product;
import learning.db.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NAgafonov
 */
@Service
public class UserProductServiceImpl implements UserProductService {

    private final ProductRepository productRepository;

    public UserProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getUserProducts(Long userId) {
        List<Product> productList = productRepository.getAllUserProducts(userId);
        return productList.stream().map(product -> new ProductDto(product.getId(),
                        product.getAccountNumber(),
                        product.getBalance(),
                        product.getProductType(),
                        product.getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.getProduct(productId);
        return new ProductDto(product.getId(),
                product.getAccountNumber(),
                product.getBalance(),
                product.getProductType(),
                product.getUserId());
    }
}
