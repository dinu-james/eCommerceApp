package com.sv.ecommerceapp.orders.ordersmicroservice.repositry;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
