package learning.db.controller;

import learning.db.dto.ProductDto;
import learning.db.dto.UserProductsResponseDto;
import learning.db.service.UserProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NAgafonov
 */
@RestController
@RequestMapping("user-product/api/v1/")
public class UserProductController {

    private final UserProductService userProductService;

    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    @GetMapping("/{userId}")
    UserProductsResponseDto getUserProducts(@PathVariable Long userId) {
        return new UserProductsResponseDto(userProductService.getUserProducts(userId));
    }

    @GetMapping("/product/{productId}")
    ProductDto getProduct(@PathVariable Long productId) {
        return userProductService.getProduct(productId);
    }
}
