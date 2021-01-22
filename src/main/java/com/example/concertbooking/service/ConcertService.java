package com.example.concertbooking.service;

import com.example.concertbooking.dao.ConcertDAO;
import com.example.concertbooking.domain.ConcertReservation;
import com.example.concertbooking.pojo.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //@Component
public class ConcertService {

//    @Autowired
//    public ConcertDAO concertDAOImpl;
    //java reflection
    // tightly couply IoC container

//    public ConcertDAO concertDAOImpl;
//    @Autowired
//    public ConcertService (ConcertDAO concertDAOImpl){
//        this.concertDAOImpl = concertDAOImpl;
//    }

    public ConcertDAO concertDAOImpl;

    @Autowired
    public void setConcertDAOImpl(ConcertDAO concertDAOImpl){
        this.concertDAOImpl = concertDAOImpl;
    }

    @Transactional
    public List<Concert> getAllConcerts(){
        return concertDAOImpl.getAllConcerts();
    }

    @Transactional
    public Concert getConcertById(Integer id){
        return concertDAOImpl.getConcertByID(id);
    }
    @Transactional
    public List<ConcertReservation> getReservationByUserid(Integer id){
        return concertDAOImpl.getConcertReservationByID(id);

    }

}
