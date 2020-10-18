package com.example.ecommerce.CatalogueDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.CatalogueDemo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
