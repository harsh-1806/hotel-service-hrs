package com.harsh.hotelrating.HotelService.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class HotelDTO {
    private UUID hotelId;
    private String name;
    private String location;
    private String about;
}
