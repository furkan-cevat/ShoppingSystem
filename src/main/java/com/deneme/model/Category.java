package com.deneme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
=======

import javax.persistence.*;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    private String name;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "category")
    @JsonIgnore
<<<<<<< HEAD
    private Set<Product> products = new HashSet<>();
=======
    private Set<Product> products = new HashSet<Product>();
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


<<<<<<< HEAD
=======


>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
}