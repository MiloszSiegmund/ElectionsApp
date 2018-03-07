package com.app.dao;

import com.app.model.Constituency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstituencyDao extends JpaRepository<Constituency, Long> {
}
