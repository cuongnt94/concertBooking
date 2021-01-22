package com.example.concertbooking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ConcertReservation {
    private String title;
    private String description;
    private String time;
    private String duration;
    private Integer user_id;
    private Integer tickets_count;
    private String created_at;
}
