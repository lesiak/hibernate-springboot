package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.CommodityPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityPriceRepository extends JpaRepository<CommodityPrice, Long>  {
}
