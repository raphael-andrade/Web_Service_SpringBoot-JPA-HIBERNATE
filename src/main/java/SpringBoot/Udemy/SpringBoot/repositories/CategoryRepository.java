package SpringBoot.Udemy.SpringBoot.repositories;

import SpringBoot.Udemy.SpringBoot.entities.Category;
import SpringBoot.Udemy.SpringBoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
