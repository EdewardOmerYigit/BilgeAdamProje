package com.beyazesya.dto.houseıtem;

import com.beyazesya.dto.common.EnumDTO;
import com.beyazesya.dto.model.ModelDTO;
import com.beyazesya.entities.HouseItems;
import lombok.Data;

@Data
public class HouseItemsDTO {
    private Integer id;
    private ModelDTO model;
    private Integer year;
    private EnumDTO Piece;
    private EnumDTO color;
    private EnumDTO Energy;
    private HouseItemsDTO houseItemsDTO;

    public static HouseItemsDTO toDTO(HouseItems houseItems) {
        HouseItemsDTO dto = new HouseItemsDTO();
        // HouseItems nesnesinden gelen verileri dto nesnesine kopyala

        return dto;
}
}

