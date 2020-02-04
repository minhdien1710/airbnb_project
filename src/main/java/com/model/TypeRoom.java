package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_room")
@Data
public class TypeRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "typeRoom", cascade = CascadeType.ALL)
    private List<Home> homes;
}
