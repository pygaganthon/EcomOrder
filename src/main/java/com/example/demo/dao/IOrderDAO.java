package com.example.demo.dao;

import com.example.demo.entity.EntityOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDAO extends JpaRepository<EntityOrder, Long>
{

}
