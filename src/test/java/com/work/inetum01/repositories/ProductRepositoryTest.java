package com.work.inetum01.repositories;

import com.work.inetum01.entities.Category;
import com.work.inetum01.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;





@DisplayName("Product repository Test...")
class ProductRepositoryTest {



    @Mock protected ProductRepository underTest ;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        setCategory() ;
        setProduct() ;
    }

    protected void setCategory() {

        Category category = new Category() ;
        category.setName("info");
        category.setId(1);
    }
    protected void setProduct() {
        Product product = new Product() ;
        Category category = new Category() ;
        product.setId(1);
        product.setName("informatique");
        product.setQt(100);
        product.setDisp(true); ;
        setCategory();
        product.setCat(category);

    }




    @Test
    void it_should_get_Bycategory() {
        // given
        List<Product> expected ;


        // when
         expected = underTest.getBycategory(1) ;

        //then

        assertThat(expected).contains() ;
    }
}