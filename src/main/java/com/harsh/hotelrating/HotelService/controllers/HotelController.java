package com.harsh.hotelrating.HotelService.controllers;


import com.harsh.hotelrating.HotelService.dtos.HotelDTO;
import com.harsh.hotelrating.HotelService.entities.Hotel;
import com.harsh.hotelrating.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDTO> getHotel(
            @PathVariable
            UUID hotelId
    ) {
        Hotel hotel = hotelService.getHotel(hotelId);

        return new ResponseEntity<>(mapToHotelDto.apply(hotel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotel() {
        List<HotelDTO> hotels = hotelService.getAllHotel().stream().map(mapToHotelDto).toList();

        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HotelDTO> createUser(
            @RequestBody
            HotelDTO hotelDTO
    ) {
        Hotel hotel = hotelService.saveHotel(hotelDTO);
        return new ResponseEntity<>(mapToHotelDto.apply(hotel), HttpStatus.CREATED);
    }


    private final Function<Hotel, HotelDTO> mapToHotelDto = (hotel) -> {
        return HotelDTO.builder()
                .hotelId(hotel.getHotelId())
                .about(hotel.getAbout())
                .location(hotel.getLocation())
                .name(hotel.getName())
                .build();
    };
}
