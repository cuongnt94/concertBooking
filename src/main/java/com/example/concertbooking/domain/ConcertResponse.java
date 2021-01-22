package com.example.concertbooking.domain;

import com.example.concertbooking.pojo.Concert;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConcertResponse {

    private ServiceStatus serviceStatus;
    private List<Concert> concertList;
    private Concert concert;
    private List<ConcertReservation> reservationlist;


}
