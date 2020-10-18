package com.sv.ecommerceapp.cartmicroservice.repository;

import com.sv.ecommerceapp.cartmicroservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item,Integer> {

}
