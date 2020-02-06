package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Data;


import javax.persistence.*;
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
    @OneToMany(targetEntity = File.class,mappedBy = "home", cascade = CascadeType.ALL)
    private Set<File> files;

    @ManyToOne
    @JsonProperty
    private User user;

    @ManyToOne
    private TypeRoom typeRoom;

    @ManyToOne
    private TypeHome typeHome;

    @JsonIgnore
    @OneToMany(targetEntity = Comment.class,mappedBy = "home",cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @JsonIgnore
    @OneToMany(targetEntity = Booking.class,orphanRemoval = true)
    private Set<Booking> bookings;
    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this).add("User",user).toString();
    }

}
