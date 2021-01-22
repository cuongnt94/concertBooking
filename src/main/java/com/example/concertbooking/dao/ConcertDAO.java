package com.example.concertbooking.dao;

import com.example.concertbooking.domain.ConcertReservation;
import com.example.concertbooking.pojo.Concert;

import java.util.List;

public interface ConcertDAO {
    public List<Concert> getAllConcerts();
    public Concert getConcertByID(Integer id);
    public List<ConcertReservation> getConcertReservationByID(Integer user_id);
}
