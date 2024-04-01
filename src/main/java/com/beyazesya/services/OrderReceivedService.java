package com.beyazesya.services;


import com.beyazesya.dto.houseıtem.HouseItemsDTO;
import com.beyazesya.dto.houseıtem.HouseItemsSaveDTO;
import com.beyazesya.entities.OrderReceived;
import com.beyazesya.repository.OrderReceivedRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderReceivedService {

    private final OrderReceivedRepository orderReceivedRepository;

    public OrderReceivedService(OrderReceivedRepository orderReceivedRepository) {
        this.orderReceivedRepository = orderReceivedRepository;
    }

    @Transactional
    public HouseItemsDTO saveHouseItems(HouseItemsSaveDTO dto) {
        OrderReceived orderReceived = new OrderReceived();
        // Burada yeni bir sipariş oluşturulduğu için save metoduna parametre olarak orderReceived nesnesi verilmelidir.
        orderReceived = orderReceivedRepository.save(orderReceived);
        return convertToDTO(orderReceived);
    }

    public List<HouseItemsDTO> getAllHouseItems() {
        List<OrderReceived> houseItemsList = orderReceivedRepository.findAll();
        return houseItemsList.stream()
                .map(this::convertToDTO) // Method reference kullanarak convertToDTO metodunu çağırabiliriz.
                .collect(Collectors.toList());
    }

    private HouseItemsDTO convertToDTO(OrderReceived orderReceived) {
        HouseItemsDTO dto = new HouseItemsDTO();
        dto.setId(Math.toIntExact(orderReceived.getId()));
        // Diğer alanları da uygun şekilde doldurun
        return dto;
    }


    // Gereksiz olan save metodunu kaldırdım.
}
