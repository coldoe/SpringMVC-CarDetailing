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
            "where not exists " +
            "(select order_id from workers_orders w where w.order_id = o.id);\n",nativeQuery = true)
    Collection<Order> getAllNotAssignOrdersToWorker();
}
