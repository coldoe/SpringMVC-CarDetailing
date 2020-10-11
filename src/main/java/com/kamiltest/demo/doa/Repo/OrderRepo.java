package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order,Long> {
}
