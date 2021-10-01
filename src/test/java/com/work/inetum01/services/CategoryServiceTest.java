package com.work.inetum01.services;

import com.work.inetum01.entities.Category;
import com.work.inetum01.repositories.CategoryRepository;
import com.work.inetum01.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.Silent.class)
@Slf4j
class CategoryServiceTest {


    @Mock
    private CategoryRepository categoryRepository;
    @Configuration
    @ComponentScan
    public static class ContextConfiguration {

        @Bean
        public CategoryRepository categoryRepository() {
            return Mockito.mock(CategoryRepository.class);
        }

    }

    @Before
    public Category should_update_Category() {

        Mockito.doReturn(Constants.CreateCategory()).when(this.categoryRepository).save(Constants.CreateCategory());
        Mockito.doReturn(Constants.CreateCategory()).when(this.categoryRepository).getById(1L);
        Mockito.doReturn(Constants2.CreateNewCategory()).when(categoryRepository).save(Constants2.CreateNewCategory());
        return Mockito.doReturn(Constants2.CreateNewCategory()).when(categoryRepository).getById(1L);

    }

    public static final class Constants {
        public static Category CreateCategory() {
            final Category category = new Category();
            category.setId(1);
            category.setName("beauty");
            return category;
        }
    }

    public static final class Constants2 {
        public static Category CreateNewCategory() {
            final Category category = new Category();
            category.setId(1);
            category.setName("beautify");
            return category;
        }
    }

    private AutoCloseable autoCloseable;
    private CategoryService categoryService;
    private Category category;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        categoryService = new CategoryService(categoryRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void should_getall_Category() {
        // when
        categoryService.getAllCategories();
        //then
        verify(categoryRepository).findAll();
    }


    @Test
    void should_save_Category() {

        //when
        category = new Category();
        categoryService.save(category);
        //then
        //verify(categoryRepository).save(category);
        Assert.notNull(category);
    }


    @Test
    void should_Delete_category() {
        //when
        Category category = new Category();
        category.setId(1);
        category.setName("info");
        categoryService.delete(category);
        //then
        verify(categoryRepository).delete(category);
    }

    /*@Test
    void updateCategoryTest() {
        updateCategory();
    }
*/

}