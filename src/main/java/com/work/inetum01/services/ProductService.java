package com.work.inetum01.services;

import com.work.inetum01.entities.Product;
import com.work.inetum01.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProduct() {
        return this.productRepository.findAll();
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);

    }

    /*public Product updateProduct(Product p, Long id) {
        Product x = this.productRepository.getById(id) ;
        if (x!=null) {
            x.setCat(p.getCat());
            x.set Name(p.getName());
            x.setQt(p.getQt());
            x.setUpdated_at(p.getUpdated_at());
            this.productRepository.save(x) ;
        }
        return x;
    }*/

    /* public void addProduct(Product p) {
         this.productRepository.save(p);

     }
 */
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product save(Product product) {
        this.productRepository.save(product);
        return product;
    }

    public Optional<Product> findById(long id) {
        return this.productRepository.findById(id);
    }

    public void delete(Long productId) {
        this.productRepository.deleteById(productId);
    }

    public List<Product> listProductBycategory(Long id) {
        return this.productRepository.getBycategory(id);
    }


}
