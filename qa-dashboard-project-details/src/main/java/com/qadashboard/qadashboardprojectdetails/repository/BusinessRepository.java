package com.qadashboard.qadashboardprojectdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qadashboard.qadashboardprojectdetails.models.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {

}
