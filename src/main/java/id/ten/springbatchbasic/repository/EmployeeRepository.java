package id.ten.springbatchbasic.repository;

import id.ten.springbatchbasic.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
}