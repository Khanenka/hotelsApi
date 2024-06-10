package com.khanenka.hotelsApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "HOTEL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Hotel {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String brand;

        @Column(nullable = false)
        private String description;

        @Embedded
        private Address address;

        @Embedded
        private Contacts contacts;

        @Embedded
        private ArrivalTime arrivalTime;

        @ElementCollection
        private List<String> amenities;

    }


