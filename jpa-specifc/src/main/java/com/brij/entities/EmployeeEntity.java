package com.brij.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "employees")
@Data
public class EmployeeEntity {
    @Id
    int id;
    @Column
    String name;
    @Column
    String email;
    @Column
    double salary;
}
