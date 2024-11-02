package com.springinaction.parogcloud.repository;

import com.springinaction.parogcloud.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
