package com.service;

import com.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findAll();
    Optional<Booking> findById(Long id);
    Booking save(Booking booking);
    void delete(Long id);
    List<Booking> findBookingByUserId(Long id);
}
