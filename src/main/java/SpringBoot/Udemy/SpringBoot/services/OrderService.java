package SpringBoot.Udemy.SpringBoot.services;

import SpringBoot.Udemy.SpringBoot.entities.Order;
import SpringBoot.Udemy.SpringBoot.entities.User;
import SpringBoot.Udemy.SpringBoot.repositories.OrderRepository;
import SpringBoot.Udemy.SpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
       Optional<Order> obj = orderRepository.findById(id);
       return obj.get();
    }
}
