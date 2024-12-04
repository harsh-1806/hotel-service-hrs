package com.harsh.hotelrating.HotelService.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hotelId;

    private String name;
    private String location;
    private String about;
}
