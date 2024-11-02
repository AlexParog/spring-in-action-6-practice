package com.springinaction.parogcloud.repository;

import com.springinaction.parogcloud.entity.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
