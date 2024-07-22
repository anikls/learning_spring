package learning.db.repository;

import learning.db.dto.ProductType;
import learning.db.entity.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NAgafonov
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final DataSource dataSource;

    public ProductRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    void createData() {
        this.createProduct(new Product(1L,"12345678", 456, ProductType.ACCOUNT, 1L));
        this.createProduct(new Product(2L,"111111123", 0, ProductType.ACCOUNT, 1L));
        this.createProduct(new Product(3L,"11-22-33-44", 100, ProductType.CARD, 1L));
        this.createProduct(new Product(4L,"99-99-99-99", 0, ProductType.CARD, 2L));
    }

    @PreDestroy
    void clearData() {
        this.deleteProduct(1L);
        this.deleteProduct(2L);
        this.deleteProduct(3L);
        this.deleteProduct(4L);
    }

    @Override
    public void createProduct(Product product) {
        System.out.println("created product ");
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.execute("INSERT INTO products (id,accountNumber,balance,productType,userId) VALUES (" +
                    product.getId() + ",'" +
                    product.getAccountNumber() + "'," +
                    product.getBalance() + ",'" +
                    product.getProductType().name() + "'," +
                    product.getUserId() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("created product id=" + product.getId());
    }

    @Override
    public Product getProduct(Long id) {
        System.out.println("get product by " + id);
        Product product = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Products WHERE id = " + id);
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getLong("id"));
                product.setAccountNumber(rs.getString("accountNumber"));
                product.setBalance(rs.getInt("balance"));
                product.setProductType(ProductType.valueOf(rs.getString("productType")));
                product.setUserId(rs.getLong("userId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllUserProducts(Long userId) {
        System.out.println("get all user products ");
        List<Product> productList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Products WHERE userId = " + userId);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setAccountNumber(rs.getString("accountNumber"));
                product.setBalance(rs.getInt("balance"));
                product.setProductType(ProductType.valueOf(rs.getString("productType")));
                product.setUserId(rs.getLong("userId"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void deleteProduct(Long idProduct) {
        System.out.println("remove product by " + idProduct);
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM Products WHERE id = " + idProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
