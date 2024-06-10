package com.khanenka.hotelsApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Embeddable
public class Address {

    @Column(nullable = false)
    private int houseNumber;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String county;

    @Column(nullable = false)
    private String postCode;

}