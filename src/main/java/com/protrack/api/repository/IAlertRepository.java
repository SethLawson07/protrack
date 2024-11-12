package com.protrack.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protrack.api.entity.Alert;

public interface IAlertRepository extends JpaRepository<Alert,Long> {
    
}
