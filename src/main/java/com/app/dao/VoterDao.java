package com.app.dao;

import com.app.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterDao extends JpaRepository<Voter, Long> {
}
