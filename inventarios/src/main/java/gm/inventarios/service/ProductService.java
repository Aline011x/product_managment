package gm.inventarios.service;
import java.util.List;

import gm.inventarios.model.Product;


public interface ProductService {

    public List<Product> listProducts();
    public Product getProductId(Integer productId);
    public Product saveProduct(Product product);
    public void deleteProduct(Integer productId);
}
