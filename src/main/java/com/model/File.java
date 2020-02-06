package com.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;

    @ManyToOne
    private Home home;

    }
