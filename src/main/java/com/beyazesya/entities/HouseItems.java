package com.beyazesya.entities;
import com.beyazesya.enums.Color;
import com.beyazesya.enums.EnergyClass;
import com.beyazesya.enums.HouseItemsType;
import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "house_items")
public class HouseItems extends BaseEntity {

    @Column(name = "year")
    private Integer year;

    @Enumerated(EnumType.STRING)
    private HouseItemsType houseItemsType;

    @Enumerated(EnumType.STRING)
    private EnergyClass energyClass;


    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "model_id", referencedColumnName = "id")
//    private Model model;
//
//    @OneToMany(mappedBy = "houseItems", fetch = FetchType.LAZY) // Alan adı ve mappedBy değeri düzeltilmiş
//    private List<OrdersReceived> ordersReceiveds;

}
