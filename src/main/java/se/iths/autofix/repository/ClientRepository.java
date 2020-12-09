package se.iths.autofix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.autofix.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByUsername (String username);
}
