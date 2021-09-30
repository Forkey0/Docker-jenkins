package com.work.inetum01.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends AuditModel {

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public void addProduct (Product product) {
        this.productList.add(product) ;
    }

    @Column( name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  id  ;
    @Column ( name="name")
    private String name ;
    @OneToMany(mappedBy = "cat")
    private List<Product> productList ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
