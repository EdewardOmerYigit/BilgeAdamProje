package com.beyazesya.controller;

import com.beyazesya.dto.houseıtem.HouseItemsDTO;
import com.beyazesya.dto.houseıtem.HouseItemsSaveDTO;
import com.beyazesya.services.OrderReceivedService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderReceived")
public class OrderRiceivedController {


    private final OrderReceivedService orderReceivedService;

    public OrderRiceivedController(OrderReceivedService orderReceivedService) {
        this.orderReceivedService = orderReceivedService;
    }

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String isRunning() {
        return "API is working";
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HouseItemsDTO saveHouseItems(@RequestBody HouseItemsSaveDTO dto) {
        return orderReceivedService.saveHouseItems(dto); // saveHouseItems metodu kullanılmalıdır.
    }


    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HouseItemsDTO> getAllOrderReceived() {
        return orderReceivedService.getAllHouseItems();
    }

}
