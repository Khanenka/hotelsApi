package com.khanenka.hotelsApi.repository;

import com.khanenka.hotelsApi.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findAll();

    Optional<Hotel> findById(Long id);

    List<Hotel> findByAddress_City(String city);


}
