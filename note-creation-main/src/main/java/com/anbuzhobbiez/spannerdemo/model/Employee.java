package com.anbuzhobbiez.spannerdemo.model;

import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "students")
@Data
@AllArgsConstructor
public class Employee {
    @PrimaryKey
    private Integer studentId;
    private String name;
    private String universityName;
}
