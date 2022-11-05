package SpringBoot.Udemy.SpringBoot.repositories;

import SpringBoot.Udemy.SpringBoot.entities.OrderItem;
import SpringBoot.Udemy.SpringBoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
