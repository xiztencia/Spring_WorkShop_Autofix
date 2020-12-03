package se.iths.autofix.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.autofix.entity.Item;
import se.iths.autofix.entity.Service;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {

//    @Query("SELECT i FROM Item i WHERE i.user.id = :id")
//    Iterable<Service> findSevicesByServiceType(String type);
//
//    @Query("SELECT i FROM Item i WHERE i.user.username = :#{ principal?.username }")
//    List<Service> findAllByService();

}
