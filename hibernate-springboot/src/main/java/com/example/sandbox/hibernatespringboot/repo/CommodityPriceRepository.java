package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.CommProfile;
import com.example.sandbox.hibernatespringboot.model.common.CommodityPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityPriceRepository extends JpaRepository<CommodityPrice, Long>  {
}
