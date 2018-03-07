package com.app.dao;

import com.app.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Long> {
}
