package se.iths.autofix.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.autofix.entity.Maintenance;

import java.util.List;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, Long> {

    @Query("SELECT m FROM Maintenance m WHERE m.mainten_client.id = :id")
    Iterable<Maintenance> findAllMaintenancesByClientId(Long id);

    @Query("SELECT m FROM Maintenance m WHERE m.mainten_client.username = :#{ principal?.username }")
    List<Maintenance> findAllMaintenancesByClientUsername();


}
