package com.khanenka.hotelsApi.controller;


import com.khanenka.hotelsApi.entity.Hotel;
import com.khanenka.hotelsApi.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/property-view")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok().body(hotels);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelService.getHotelById(id);
        return hotel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotelsByCity(@RequestParam(name = "city") String city) {
        List<Hotel> hotels = hotelService.searchHotelsByCity(city);
        return ResponseEntity.ok().body(hotels);
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel newHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @PostMapping("/hotels/{id}/amenities")
    public ResponseEntity<Void> addAmenitiesToHotel(@PathVariable Long id, @RequestBody List<String> amenities) {
        hotelService.addAmenitiesToHotel(id, amenities);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String, Integer>> getHistogramByParam(@PathVariable String param) {
        Map<String, Integer> histogram = hotelService.getHistogramByParam(param);
        return ResponseEntity.ok(histogram);
    }


}