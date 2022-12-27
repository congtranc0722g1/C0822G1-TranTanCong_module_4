package com.furama_resort.repository;

import com.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like concat('%', :name, '%')  and email like concat('%', :email, '%') and customer_type_id like concat('%', :CustomerTypeId, '%') ", nativeQuery = true)
    Page<Customer> findAllSearch(@Param("name") String name, @Param("email") String email, @Param("CustomerTypeId") String customerTypeId, Pageable pageable);
}
