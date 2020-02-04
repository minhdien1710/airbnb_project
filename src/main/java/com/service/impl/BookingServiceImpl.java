package com.service.impl;

import com.model.Booking;
import com.repository.BookingRepository;
import com.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findBookingByUserId(Long id) {
        return bookingRepository.findBookingByUserId(id);
    }
}
