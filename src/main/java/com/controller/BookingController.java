package com.controller;

import com.formatter.BooleanDate;
import com.model.Booking;
import com.model.Home;
import com.model.User;
import com.repository.BookingRepository;
import com.repository.HomeRepository;
import com.security.auth.UserPrincipal;
import com.service.BookingService;
import com.service.HomeService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/bookings")
public class BookingController {
    private UserPrincipal getCurrentUser() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Autowired
    private BookingService bookingService;
    @Autowired
    private HomeService homeService;
    @Autowired
    private UserService userService;
    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private BookingRepository bookingRepository;


    @PostMapping("/booking-list")
    public ResponseEntity<?> bookings(){
        Long userId = getCurrentUser().getId();
        List<Booking> bookingList = this.bookingService.findBookingByUserId(userId);
        if(bookingList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }
    @PostMapping(value = "booking/{homeId}",
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            consumes = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> bookingHome(@PathVariable Long homeId, @RequestBody Booking booking) throws ParseException {
        boolean check = BooleanDate.afterBefore(booking.getCheckInDate(),booking.getCheckOutDate());
        if(!check) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Optional<Home> home = homeService.findById(homeId);
        booking.setHome(home.get());
        Date now = new Date();
        booking.setCreateDate(now);
        Optional<User> user = userService.findById(getCurrentUser().getId());
        booking.setUser(user.get());
        bookingService.save(booking);
        homeService.save(home.get());
        return new ResponseEntity<>(booking,HttpStatus.OK);
    }
}
