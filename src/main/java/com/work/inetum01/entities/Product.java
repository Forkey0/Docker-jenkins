package com.work.inetum01.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.ManyToOne;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="Product")

public class Product extends AuditModel {


    public Product () {

    }
    public Product(long id, String name, int qt, Boolean disp, Category cat) {
        this.id = id;
        this.name = name;
        this.qt = qt;
        this.disp = disp;
        this.cat = cat; }

    @Column( name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  id  ;
    @Column ( name="name")
    private String name ;
    @Column ( name="qt")
    private int qt ;
    @Column ( name="disp")
    private Boolean disp ;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false) // clé étrangère
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category cat;


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

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public Boolean getDisp() {
        return disp;
    }

    public void setDisp(Boolean disp) {
        this.disp = disp;
    }
    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

}
