package com.brij.repository;

import com.brij.entities.Employee;
import com.brij.entities.EmployeeEntity;
import com.brij.entities.EmployeeI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {


//    @Query("SELECT e.name, e.email from employees e where id = ?1")
//    Optional<EmployeeEntity> findById(int id);

    @Query("SELECT e.name, e.email from employees e where id = ?1")
    List<Object[]> findNameAndEmailByIdO(int id);

    @Query("SELECT new com.brij.entities.Employee(e.name, e.email) from employees e where id = ?1")
    Employee findNameAndEmailById(int id);

    @Query("SELECT e from employees e where id = ?1")
    EmployeeI findINameAndEmailById(int id);
}
