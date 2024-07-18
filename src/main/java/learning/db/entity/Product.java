package learning.db.entity;

import learning.db.dto.ProductType;

/**
 * @author NAgafonov
 */
public class Product {

    private Long id;
    private String accountNumber;
    private Integer balance;
    private ProductType productType;
    private Long userId;

    public Product() {
    }

    public Product(Long id, String accountNumber, Integer balance, ProductType productType, Long userId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
