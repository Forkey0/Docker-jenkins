package com.work.inetum01.services;

import com.work.inetum01.entities.Category;
import com.work.inetum01.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private  final CategoryRepository categoryrepository ;
     @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryrepository = categoryRepository;
     }

    public List<Category> getAllCategories(){
      return this.categoryrepository.findAll();
    }


    public Optional<Category> findById(long id) {
         return this.categoryrepository.findById(id);
    }

    public Category save(Category category) {
         this.categoryrepository.save(category) ;
        return category;
    }

    public void delete(Category categoryId) {
         this.categoryrepository.delete(categoryId);
    }

    public Category updatecategory (long id , Category categoryup) {

        Optional<Category> category = findById(id);
        
        category.get().setName(categoryup.getName());

        category.get().setUpdated_at(categoryup.getUpdated_at());

        return this.categoryrepository.save(category.get());

    }
}



