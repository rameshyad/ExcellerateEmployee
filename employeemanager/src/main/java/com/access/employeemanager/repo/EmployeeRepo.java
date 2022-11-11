package com.access.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.access.employeemanager.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	@Query(value="Delete from Employee e where e.id=:n1", nativeQuery = true)
	void deleteEmployeeById(@Param("n1")Long id);
	@Query(value="Select * from Employee e where e.id=:n", nativeQuery = true)
	Optional<Employee> findEmployeeById(@Param("n")Long id);

}
