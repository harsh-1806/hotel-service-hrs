package com.harsh.hotelrating.HotelService.services;

import com.harsh.hotelrating.HotelService.dtos.HotelDTO;
import com.harsh.hotelrating.HotelService.entities.Hotel;

import java.util.List;
import java.util.UUID;

public interface HotelService {
    // create
    Hotel saveHotel(HotelDTO hotelDTO);

    // read
    Hotel getHotel(UUID hotelId);
    List<Hotel> getAllHotel();

    // TODO: update
    // TODO: delete
}
