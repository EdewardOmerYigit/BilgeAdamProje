package com.beyazesya.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "orders_received")
public class OrdersReceived extends BaseEntity {

    private String name;


}