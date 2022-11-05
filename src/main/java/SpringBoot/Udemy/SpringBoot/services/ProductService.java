package SpringBoot.Udemy.SpringBoot.services;

import SpringBoot.Udemy.SpringBoot.entities.Product;
import SpringBoot.Udemy.SpringBoot.entities.User;
import SpringBoot.Udemy.SpringBoot.repositories.ProductRepository;
import SpringBoot.Udemy.SpringBoot.repositories.UserRepository;
import SpringBoot.Udemy.SpringBoot.services.exceptions.DatabaseException;
import SpringBoot.Udemy.SpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id){
       Optional<Product> obj = productRepository.findById(id);
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Product insert(Product obj) {
        return productRepository.save(obj);
    }
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    public Product update(Long id, Product obj) {
        try {
            Product entity = productRepository.getReferenceById(id);
            updateData(entity, obj);
            return productRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
}
