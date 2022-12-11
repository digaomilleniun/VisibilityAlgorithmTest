package br.com.rpires.VisibilityAlgorithmTest.repository;

import br.com.rpires.VisibilityAlgorithmTest.domain.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SizeRepository extends CrudRepository<Size, Long> {

    Page<Size> findAll(Pageable pageable);
    //@Query("SELECT * FROM Size WHERE id in(:sizeIds)")
    Collection<Size> findAllAvailableByIdInAndBackSoonTrue(List<Long> sizeIds);
}