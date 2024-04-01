package com.beyazesya.services;
import com.beyazesya.dto.houseıtem.HouseItemsDTO;
import com.beyazesya.dto.houseıtem.HouseItemsSaveDTO;
import com.beyazesya.entities.HouseItems;
import com.beyazesya.repository.HouseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class HouseItemsService {

    private final HouseItemRepository houseItemRepository;

    @Autowired
    public HouseItemsService(HouseItemRepository houseItemRepository) {
        this.houseItemRepository = houseItemRepository;
    }

    public List<HouseItemsDTO> getAllHouseItems() {
        List<HouseItems> houseItemsList = houseItemRepository.findAll();
        List<HouseItemsDTO> collect = houseItemsList.stream()
                .map((HouseItems houseItems) -> HouseItemsDTO.toDTO(houseItems))
                .collect(Collectors.toList());
        return collect;
    }

    public HouseItemsDTO getHouseItemById(Long id) {
        HouseItems houseItem = houseItemRepository.findById(id)
                .orElseThrow();
        return HouseItemsDTO.toDTO(houseItem);
    }

    public HouseItemsDTO saveHouseItem(HouseItemsSaveDTO houseItemsSaveDTO) {
        HouseItems houseItem = new HouseItems();
        houseItem.setName(houseItemsSaveDTO.getName());
        houseItem.setDescription(houseItemsSaveDTO.getDescription());
        // Diğer alanları ayarla

        HouseItems savedHouseItem = houseItemRepository.save(houseItem);
        return HouseItemsDTO.toDTO(savedHouseItem);
    }

    public HouseItemsDTO updateHouseItem(Long id, HouseItemsSaveDTO houseItemsSaveDTO) {
        HouseItems houseItem = houseItemRepository.findById(id)
                .orElseThrow();
        houseItem.setName(houseItemsSaveDTO.getName());
        houseItem.setDescription(houseItemsSaveDTO.getDescription());
        // Diğer alanları güncelle

        HouseItems updatedHouseItem = houseItemRepository.save(houseItem);
        return HouseItemsDTO.toDTO(updatedHouseItem);
    }

    public void deleteHouseItem(Long id) {
        houseItemRepository.deleteById(id);
    }
}
