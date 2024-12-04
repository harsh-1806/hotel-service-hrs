package com.harsh.hotelrating.HotelService.services.impl;

import com.harsh.hotelrating.HotelService.dtos.HotelDTO;
import com.harsh.hotelrating.HotelService.entities.Hotel;
import com.harsh.hotelrating.HotelService.exceptions.ResourceNotFoundException;
import com.harsh.hotelrating.HotelService.repositories.HotelRepository;
import com.harsh.hotelrating.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel saveHotel(HotelDTO hotelDTO) {
        Hotel hotel = mapToHotel.apply(hotelDTO);

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(UUID hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel Not found with hotelId : " + hotelId));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    private final Function<HotelDTO, Hotel> mapToHotel = (hotelDTO) -> Hotel.builder()
            .about(hotelDTO.getAbout())
            .name(hotelDTO.getName())
            .location(hotelDTO.getLocation())
            .build();
}
