package com.be.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.model.Device;


@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{
    @Query("SELECT d FROM Device d WHERE d.deleteAt IS NULL")
    List<Device> findByDeletedAtIsNull();

    @Query("SELECT d FROM Device d WHERE d.deleteAt IS NOT NULL")
    List<Device> findByDeletedAtIsNotNull();

    @Query("SELECT d FROM Device d WHERE d.provider.nameProvider = :nameProvider")
    List<Device> findByProviderName(@Param("nameProvider") String providerName);
}
