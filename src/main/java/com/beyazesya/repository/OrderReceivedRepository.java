package com.beyazesya.repository;

import com.beyazesya.entities.OrderReceived;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderReceivedRepository extends JpaRepository<OrderReceived, Long> {

    List<OrderReceived> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date startDate, Date endDate);

//    @Query("SELECT order FROM OrderReceived order WHERE MONTH(order.startDate) = :month AND YEAR(order.startDate) = :year")
//    List<OrderReceived> getAllOrdersByMonthAndYear(@Param("month") Integer month, @Param("year") Integer year);


    @Override
    <S extends OrderReceived> S save(S entity);
}
