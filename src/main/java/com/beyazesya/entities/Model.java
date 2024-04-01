package com.beyazesya.entities;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "model")
public class Model extends BaseEntity {

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "model", fetch = FetchType.EAGER)
//    private List<HouseItems> houseItems;
}
