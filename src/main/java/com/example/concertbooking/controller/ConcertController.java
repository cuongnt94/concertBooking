package com.example.concertbooking.controller;

import com.example.concertbooking.domain.ConcertResponse;
import com.example.concertbooking.domain.ServiceStatus;
import com.example.concertbooking.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcertController {
    private ConcertService concertService;
    @Autowired
    public void setConcertService(ConcertService concertService){
        this.concertService = concertService;
    }

    @GetMapping("/concert/all")
    public ConcertResponse getAllConcerts(){
        ConcertResponse response = new ConcertResponse();
        response.setConcertList(concertService.getAllConcerts());
        prepareResponse(response, true, "");
        return response;
    }

    //    /concert/1
    @GetMapping("/concert/{id}")
    public ConcertResponse getConcertById(@PathVariable Integer id){
        ConcertResponse response = new ConcertResponse();
        response.setConcert(concertService.getConcertById(id));
        prepareResponse(response, true, "");
        return response;
    }

    //   /concert?concert_id=1
    @GetMapping("/concertreservation")
    public ConcertResponse getConcertById2(@RequestParam("user_id") Integer id){
        ConcertResponse response = new ConcertResponse();
        response.setReservationlist(concertService.getReservationByUserid(id));
        prepareResponse(response, true, "");
        return response;
    }

    private void prepareResponse(ConcertResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }
}
