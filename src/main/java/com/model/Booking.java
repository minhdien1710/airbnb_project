package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import static com.formatter.DateParse.dateParser;

@Entity
@Table(name = "booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date checkInDate;

    private Date checkOutDate;

    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;

    public String getCreateDate(){
        return dateParser(createDate,"yyyy/MM/dd HH:mm:ss");
    }
    public String getCheckInDate(){
        return dateParser(checkInDate,"yyyy/MM/dd");
    }
    public String getCheckOutDate(){
        return dateParser(checkOutDate,"yyyy/MM/dd");
    }
}
