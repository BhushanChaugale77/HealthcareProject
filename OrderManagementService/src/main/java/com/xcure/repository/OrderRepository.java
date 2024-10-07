package com.xcure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
