package com.inrix.mds.repository;

import com.inrix.mds.model.GPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPSRepo extends JpaRepository<GPS, Integer> {
}
