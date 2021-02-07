package com.example.demo.dao;

import com.example.demo.entity.EntityAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDAO extends JpaRepository<EntityAddress, Long>
{
}
