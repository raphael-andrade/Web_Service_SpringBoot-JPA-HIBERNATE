package SpringBoot.Udemy.SpringBoot.repositories;

import SpringBoot.Udemy.SpringBoot.entities.Category;
import SpringBoot.Udemy.SpringBoot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
