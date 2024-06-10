package com.khanenka.hotelsApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Embeddable
public class ArrivalTime {

    @Column(nullable = false)
    private String checkIn;

    @Column(nullable = false)
    private String checkOut;

}