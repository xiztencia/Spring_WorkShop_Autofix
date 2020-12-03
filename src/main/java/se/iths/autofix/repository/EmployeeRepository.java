package se.iths.autofix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.autofix.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByEmployeeName (String name);
}
