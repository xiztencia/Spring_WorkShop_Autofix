package se.iths.autofix.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.autofix.entity.SparePart;

import java.util.List;

@Repository
public interface SparePartRepository extends CrudRepository<SparePart, Long> {

    @Query("SELECT s FROM SparePart s WHERE s.client.id = :id")
    Iterable<SparePart> findSparePartsByClientId(Long id);

    @Query("SELECT s FROM SparePart s WHERE s.client.username = :#{ principal?.username }")
    List<SparePart> findAllSparePartsByClientUsername();

    @Query("SELECT s FROM SparePart s WHERE s.employee.id = :id")
    Iterable<SparePart> findSparePartsByEmployeeId(Long id);

    @Query("SELECT s FROM SparePart s WHERE s.employee.username = :#{ principal?.username }")
    Iterable<SparePart> findAllSparePartsByEmployeeUsername();
}
