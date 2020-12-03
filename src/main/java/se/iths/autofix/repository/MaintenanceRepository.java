package se.iths.autofix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.autofix.entity.Maintenance;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, String> {

//    @Query("SELECT i FROM Item i WHERE i.user.id = :id")
//    Iterable<Service> findSevicesByServiceType(String type);
//
//    @Query("SELECT i FROM Item i WHERE i.user.username = :#{ principal?.username }")
//    List<Service> findAllByService();

}
