package com.beyazesya.services;

import com.beyazesya.dto.common.EnumDTO;
import com.beyazesya.dto.common.SelectDataDTO;
import com.beyazesya.enums.Color;
import com.beyazesya.enums.EnergyClass;
import com.beyazesya.enums.HouseItemsType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServices {

    public List<SelectDataDTO> getAllYears() {
        List<SelectDataDTO> dtos = new ArrayList<>();
        Integer currentYear = LocalDate.now().getYear();
        for (int i = currentYear - 20; i <= currentYear; i++) {
            SelectDataDTO dto = new SelectDataDTO();
            dto.setKey(i);
            dto.setValue(String.valueOf(i));
            dtos.add(dto);
        }
        return dtos;
    }

    public List<EnumDTO> getAllColors() {
        List<EnumDTO> dtos = new ArrayList<>();
        for (Color color : Color.values()) {
            EnumDTO dto = new EnumDTO();
            dto.setOrdinal(color.ordinal());
            dto.setValue(color.name());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<EnumDTO> getAllEnergyClass() {
        List<EnumDTO> dtos = new ArrayList<>();
        for (EnergyClass energyClass : EnergyClass.values()) {
            EnumDTO dto = new EnumDTO();
            dto.setOrdinal(energyClass.ordinal());
            dto.setValue(energyClass.name());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<EnumDTO> getAllHouseItems() {
        List<EnumDTO> dtos = new ArrayList<>();
        for (HouseItemsType bodyType : HouseItemsType.values()) {
            EnumDTO dto = new EnumDTO();
            dto.setOrdinal(bodyType.ordinal());
            dto.setValue(bodyType.name());
            dtos.add(dto);
        }
        return dtos;
    }
}

