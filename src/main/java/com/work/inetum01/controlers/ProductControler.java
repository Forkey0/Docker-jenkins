package com.work.inetum01.controlers;

import com.work.inetum01.entities.Category;
import com.work.inetum01.entities.Product;
import com.work.inetum01.repositories.ProductRepository;
import com.work.inetum01.services.CategoryService;
import com.work.inetum01.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/product"})

@CrossOrigin(origins = "http://localhost:4200")
public class ProductControler {

    private final ProductService productService ;
    private final CategoryService categoryService ;


    @Autowired
    public ProductControler(ProductService productService , CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService ;
    }

@GetMapping("/list")

public List<Product> getAllProducts() {
        List<Product>  products = productService.findAll() ;
        return products ;
        }
@CrossOrigin(origins = "http://localhost:4200")
@PostMapping(path="/add/{id}")

public void createProduct(@RequestBody Product product,@PathVariable long id ) {
        Optional<Category> category = this.categoryService.findById(id);
        category.get().addProduct(product);
        product.setCat(category.get());
        productService.save(product);
        }


@PutMapping(path ="update/{Id}")
public Optional<Product> updateProduct(@PathVariable long Id , @RequestBody Product productyup) {

        Optional<Product> product = productService.findById(Id) ;
        product.get().setName(productyup.getName());
        product.get().setQt(productyup.getQt());
        product.get().setDisp(productyup.getDisp());
        product.get().setUpdated_at(productyup.getUpdated_at());
        return product ;

        }
@DeleteMapping("delete/{productId}")
public void deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
        }

@GetMapping("/list/cat/{id}")
public List<Product> getByCategory(@PathVariable Long id) {
        List<Product>  products = productService.listProductBycategory(id) ;
        return products ;
        }
        }
