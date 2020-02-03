package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "homes")
@Data
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
    private List<File> files;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
