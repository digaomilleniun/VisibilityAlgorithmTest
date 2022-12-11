package br.com.rpires.VisibilityAlgorithmTest.repository;

import br.com.rpires.VisibilityAlgorithmTest.domain.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    Page<Stock> findAll(Pageable pageable);

    //@Query("SELECT * FROM Stock WHERE quantity != 0")
    Collection<Stock> findAllAvailableByQuantityNot(Long quantity);
}