package br.com.rpires.VisibilityAlgorithmTest.repository;

import br.com.rpires.VisibilityAlgorithmTest.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    //@Query("SELECT * FROM Product WHERE id in(:productIds)")
    //@Param("productIds")
    Page<Product> findAllAvailableByIdIn(List<Long> productIds, Pageable pageable);
}
