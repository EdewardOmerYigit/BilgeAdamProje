package com.beyazesya.controller;

import com.beyazesya.dto.houseıtem.HouseItemsDTO;
import com.beyazesya.dto.houseıtem.HouseItemsSaveDTO;
import com.beyazesya.services.HouseItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houseItems")
public class HouseItemsController {

    private final HouseItemsService houseItemsService;

    @Autowired
    public HouseItemsController(HouseItemsService houseItemsService) {
        this.houseItemsService = houseItemsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<HouseItemsDTO>> getAllHouseItems() {
        List<HouseItemsDTO> houseItems = houseItemsService.getAllHouseItems();
        return ResponseEntity.ok(houseItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseItemsDTO> getHouseItemById(@PathVariable("id") Long id) {
        HouseItemsDTO houseItem = houseItemsService.getHouseItemById(id);
        return ResponseEntity.ok(houseItem);
    }

    @PostMapping
    public ResponseEntity<HouseItemsDTO> saveHouseItem(@RequestBody HouseItemsSaveDTO houseItemsSaveDTO) {
        HouseItemsDTO savedHouseItem = houseItemsService.saveHouseItem(houseItemsSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHouseItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouseItem(@PathVariable("id") Long id) {
        houseItemsService.deleteHouseItem(id);
        return ResponseEntity.ok("Silme İşlemi Başarılı.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<HouseItemsDTO> updateHouseItem(@PathVariable("id") Long id, @RequestBody HouseItemsSaveDTO houseItemsSaveDTO) {
        HouseItemsDTO updatedHouseItem = houseItemsService.updateHouseItem(id, houseItemsSaveDTO);
        return ResponseEntity.ok(updatedHouseItem);
    }
}
