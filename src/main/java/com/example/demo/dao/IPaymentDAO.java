package com.example.demo.dao;

import com.example.demo.entity.EntityPayment;
import com.example.demo.vo.PaymentVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaymentDAO extends JpaRepository<EntityPayment, Long>
{
    List<EntityPayment> findAllByOrderId(Long order_id);
}
