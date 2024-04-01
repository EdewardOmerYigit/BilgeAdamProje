package com.beyazesya.repository;


import com.beyazesya.entities.HouseItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseItemRepository extends JpaRepository<HouseItems, Long> {
}
