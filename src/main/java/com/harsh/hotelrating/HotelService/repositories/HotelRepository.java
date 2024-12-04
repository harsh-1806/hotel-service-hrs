package com.harsh.hotelrating.HotelService.repositories;

import com.harsh.hotelrating.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {
}
