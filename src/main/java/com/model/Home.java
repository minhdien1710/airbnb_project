package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String address;

    private Integer bedRoom;

    private Integer bathRoom;

    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<File> files;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_room_id")
    private TypeRoom typeRoom;

    @ManyToOne
    @JoinColumn(name = "type_home_id")
    private TypeHome typeHome;

    @OneToMany(mappedBy = "home",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Comment> comments;

}
