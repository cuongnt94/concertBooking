package com.example.concertbooking.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "concert", schema = "ticket")
public class Concert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String start_at;
    private String duration;
    private Integer tickets_amount;
    private Integer remaining_tickets;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "concert")
    @JsonIgnore
    private Set<Reservation> reservations;


}
