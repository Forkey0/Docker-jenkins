package com.work.inetum01.controlers;
import com.work.inetum01.dto.CategoryDTO;
import com.work.inetum01.entities.Category;
import com.work.inetum01.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/category"})

public class CategoryControler {

    private final CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    public CategoryControler (CategoryService categoryservice) {
        this.categoryService = categoryservice;
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Category> getAllCategory() {
        List<Category> Categories = categoryService.getAllCategories();
        return Categories;

    }


    @PostMapping("/add")
    @CrossOrigin

     public ResponseEntity<CategoryDTO> createCategory (@RequestBody CategoryDTO categorydto) {

        Category createRequest = modelMapper.map(categorydto,Category.class) ;

       Category category = categoryService.save(createRequest);

        CategoryDTO createResponce = modelMapper.map(category,CategoryDTO.class) ;

        return new ResponseEntity<>(createResponce, HttpStatus.CREATED) ;

    }

    @PutMapping("update/{id}")
    @CrossOrigin

    public ResponseEntity<CategoryDTO>  updateCategory (@PathVariable long id,@RequestBody CategoryDTO categoryDTO ) {

        Category categoryRequest = modelMapper.map(categoryDTO , Category.class) ;
        Category category = categoryService.updatecategory(id,categoryRequest) ;

        CategoryDTO categoryResponce= modelMapper.map(category,CategoryDTO.class) ;
        return ResponseEntity.ok().body(categoryResponce) ;
    }

    @DeleteMapping("delete/{categoryId}")
    @CrossOrigin

    public void deleteCategory(@PathVariable Category categoryId) {
        categoryService.delete(categoryId);
    }

}
