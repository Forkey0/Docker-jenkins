package com.work.inetum01.repositories;

import com.work.inetum01.entities.Category;
import com.work.inetum01.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query( value = "select * from  product where product.id_category =:id", nativeQuery = true)
    public List<Product> getBycategory(@Param("id")long id ) ;

}
