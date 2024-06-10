package com.khanenka.hotelsApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Embeddable
public class Contacts {

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

}