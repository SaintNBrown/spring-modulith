package org.qubiqule.springmodulith.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> getOrderByOrderIdentifier(String orderIdentifier);
}
