package gm.inventarios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gm.inventarios.exception.ProductNotFoundException;
import gm.inventarios.model.Product;
import gm.inventarios.service.LogUtil;
import gm.inventarios.service.ProductServiceC;

@RestController
@RequestMapping(value = "app")
//@CrossOrigin(value = "http://localhost:80")
@CrossOrigin(value = "*")
public class ProductController {

    private static final org.apache.logging.log4j.Logger logger  =
     LogUtil.getLogger(ProductController.class);

    @Autowired
    private ProductServiceC productService;

    @GetMapping("/products")
    public List<Product> listProducts() {
        List<Product> products = this.productService.listProducts();
        logger.info("Result get products");
        products.forEach((product -> logger.info(product.toString())));
        return products;
}

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        logger.info("Add product:  " + product);
        return this.productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable int id) {
            Product product = this.productService.getProductId(id);
            if (product != null)
                return ResponseEntity.ok(product);
            else 
                throw new ProductNotFoundException("Product not found ");
    }

    @PutMapping("/products/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable int id,
        @RequestBody Product productReceive) { 
            Product product = this.productService.getProductId(id);
            if (product == null){
                throw new ProductNotFoundException("Id product not found: " + id);  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para actualizar.  // No hay producto para
            }
            product.setDescription(productReceive.getDescription());
            product.setPrice(productReceive.getPrice());
            product.setQuantity(productReceive.getQuantity());
            this.productService.saveProduct(product);
            return ResponseEntity.ok(product);
}

    @DeleteMapping("/products/{id}")
        public ResponseEntity<Map<String, Boolean>> 
        delProduct(@PathVariable int id) {
            Product product = productService.getProductId(id);
            if (product == null){
                throw new ProductNotFoundException("Id product not found: " + id);  // No hay producto para eliminar.
            }
            this.productService.deleteProduct(product.getIdproduct());
            Map<String, Boolean> response = new HashMap<String, Boolean>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
}

}