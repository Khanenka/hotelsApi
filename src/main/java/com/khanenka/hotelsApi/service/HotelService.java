package com.khanenka.hotelsApi.service;

import com.khanenka.hotelsApi.entity.Hotel;
import com.khanenka.hotelsApi.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> searchHotelsByCity(String city) {
        List<Hotel> byAddressCity = hotelRepository.findByAddress_City(city);

        return byAddressCity;
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void addAmenitiesToHotel(Long id, List<String> amenities) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.setAmenities(amenities);
            hotelRepository.save(hotel);
        } else {
            throw new EntityNotFoundException("Hotel with id " + id + " not found");
        }
    }

    public Map<String, Integer> getHistogramByParam(String param) {
        List<Hotel> hotels = hotelRepository.findAll();
        Map<String, Integer> histogram = new HashMap<>();

        if (param.equals("city")) {
            hotels.forEach(hotel -> histogram.merge(hotel.getAddress().getCity(), 1, Integer::sum));
        } else if (param.equals("amenities")) {
            hotels.forEach(hotel -> hotel.getAmenities().forEach(amenity -> histogram.merge(amenity, 1, Integer::sum)));
        } else if (param.equals("county")) {
            hotels.forEach(hotel -> histogram.merge(hotel.getAddress().getCounty(), 1, Integer::sum));
        } else if (param.equals("brand")) {
            hotels.forEach(hotel -> histogram.merge(hotel.getBrand(), 1, Integer::sum));
        }
        return histogram;
    }


}
