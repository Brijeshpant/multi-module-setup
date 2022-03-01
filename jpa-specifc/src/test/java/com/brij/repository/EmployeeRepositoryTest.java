package com.brij.repository;

import com.brij.entities.Employee;
import com.brij.entities.EmployeeEntity;
import com.brij.entities.EmployeeI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql(scripts = "classpath:/scripts/import.sql")
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void shouldBeAbleToGetEmployeeDetails() {
        EmployeeEntity actual = employeeRepository.findById(1).orElse(new EmployeeEntity());
        EmployeeEntity expected = new EmployeeEntity();
        expected.setId(1);
        expected.setName("emp1");
        expected.setEmail("emp1@gmail.com");
        expected.setSalary(40000.0);
        assertThat(actual).isEqualTo(expected).usingRecursiveComparison();
    }

    @Test
    void shouldOnlyGetNameAndEmailInObjectArray() {
        List<Object[]> actual = employeeRepository.findNameAndEmailByIdO(1);
        Object[] objects = actual.get(0);
        assertThat(objects[0]).isEqualTo("emp1");
        assertThat(objects[1]).isEqualTo("emp1@gmail.com");
    }

    @Test
    void shouldOnlyGetNameAndEmail() {
        Employee actual = employeeRepository.findNameAndEmailById(1);
        assertThat(actual.getName()).isEqualTo("emp1");
        assertThat(actual.getEmail()).isEqualTo("emp1@gmail.com");
    }

    @Test
    void shouldOnlyGetNameAndEmailByIdUsingInterface() {
        EmployeeI actual = employeeRepository.findINameAndEmailById(1);
        assertThat(actual.getName()).isEqualTo("emp1");
        assertThat(actual.getEmail()).isEqualTo("emp1@gmail.com");
    }
}
