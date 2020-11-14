package com.kamiltest.demo.doa.Repo;

import com.kamiltest.demo.doa.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderRepo extends CrudRepository<Order,Long> {
    @Query(value = "select * \n" +
            "from orders o \n" +
            "where o.is_done = 0 and o.is_payed = 0 and  \n" +
            "not exists (select order_id \n" +
            "from workers_orders w \n" +
            "where w.order_id = o.id);",nativeQuery = true)
    Collection<Order> getAllNotAssignOrdersToWorker();
}
