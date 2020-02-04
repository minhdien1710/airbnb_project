package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_home")
@Data
public class TypeHome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "typeHome",cascade = CascadeType.ALL)
    private List<Home> homes;
}
