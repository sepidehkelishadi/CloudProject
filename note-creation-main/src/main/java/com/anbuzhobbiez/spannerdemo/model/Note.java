package com.anbuzhobbiez.spannerdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Table(name = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private int id;
    private String subject;
    private String content;
    private String image;
}