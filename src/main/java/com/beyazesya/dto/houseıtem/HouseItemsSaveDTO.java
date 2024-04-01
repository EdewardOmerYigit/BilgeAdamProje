package com.beyazesya.dto.houseıtem;

import lombok.Data;

@Data
public class HouseItemsSaveDTO {
    private Integer id;
    private Integer modelId;
    private Integer year;
    private Integer energy;
    private Integer color;
    private Integer piece;
    private String name;
    private String description;
}
