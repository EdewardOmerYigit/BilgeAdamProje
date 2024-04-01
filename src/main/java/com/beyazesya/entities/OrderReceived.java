package com.beyazesya.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orderReceived")
public class OrderReceived extends BaseEntity  {

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "piece")
    private Integer piece;

    //TODO: Kullanıcı, Sözleşme kuralları
//
//    @OneToMany(mappedBy = "orderReceived", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<OrdersReceived> ordersReceived;
}
