package gm.inventarios.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gm.inventarios.exception.ProductNotFoundException;
import gm.inventarios.model.Product;
import gm.inventarios.repository.ProductRepository;


@Service
public class ProductServiceC implements ProductService {

    private static final org.apache.logging.log4j.Logger logger  = LogUtil.getLogger(ProductServiceC.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProducts() {
        List<Product> products = this.productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        } 
        return products;
    }

    @Override
    public Product getProductId(Integer productId) {
        return this.productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found: " + productId));
    }

    @Override
    public Product saveProduct(Product product) {
        if (product == null ) {
        throw new IllegalArgumentException("Product cannot be null");
        } 
     return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
    if  (!this.productRepository.existsById(productId)) { 
        throw new ProductNotFoundException("Product not found: "+ productId); 
    }
    logger.info("Product deleted: {}", productId); productRepository.deleteById(productId);
    }

}
