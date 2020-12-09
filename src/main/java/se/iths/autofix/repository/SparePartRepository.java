package se.iths.autofix.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.autofix.entity.SparePart;

import java.util.List;

@Repository
public interface SparePartRepository extends CrudRepository<SparePart, Long> {

//    @Query("SELECT s FROM SparePart s WHERE s.user.id = :id")
//    Iterable<SparePart> findSparePartsByUserId(Long id);
//
//    @Query("SELECT s FROM SparePart s WHERE s.user.username = :#{ principal?.username }")
//    List<SparePart> findAllByUser();
}
